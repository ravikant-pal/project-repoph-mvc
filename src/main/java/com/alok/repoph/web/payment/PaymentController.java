package com.alok.repoph.web.payment;


import com.alok.repoph.models.User;
import com.alok.repoph.pojo.HireHistory;
import com.alok.repoph.pojo.ServiceHistory;
import com.alok.repoph.services.AppService;
import com.alok.repoph.services.UserServiceImpl;
import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class PaymentController {

    @Autowired
    private PaytmDetails paytmDetails;

    @Autowired
    private Environment environment;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AppService appService;

    @GetMapping("/payment/{id}")
    public String placeOrder(@PathVariable("id") Long userId,
                             Principal principal, Model model) {

        double bill;
        User serviceUser = appService.getUserById(userId);
        User endUser = userService.findByEmail(principal.getName());
//        master.getMapOfHiredPeople().remove(id);
        serviceUser.setRequestedForEnd(true);
        userService.save(serviceUser);
        LocalTime end = LocalTime.now();
        Duration duration = Duration.between(serviceUser.getHiredStartTime(), end);
        Long seconds = duration.getSeconds();

        bill = (serviceUser.getPricing()*seconds)/(24*60*60);
        DecimalFormat df = new DecimalFormat("#.##");
        Long minutes = seconds/60;
        seconds %= 60;
        Integer hour = Math.toIntExact(minutes / 60);
        minutes %= 60;
        System.out.printf("Seconds between %s and %s is: %s hour %s minutes %s seconds.%n", serviceUser.getHiredStartTime(), end, hour,minutes,seconds);
        long randomNumber = getRandomNumber();
        String txId = "TXN_"+randomNumber;
        model.addAttribute("transactionId",txId);
        model.addAttribute("userId",endUser.getId());
        model.addAttribute("startTime",serviceUser.getHiredStartTime());
        model.addAttribute("endTime",end);
        model.addAttribute("duration",hour+" hours "+minutes+" minutes "+seconds+" seconds");
        model.addAttribute("bill",df.format(bill));
        return "payment/order-details-for-pay";
    }

//    @GetMapping("/payment/{id}")
//    public String home(@PathVariable Integer id,Model model) {
//
//        return "home";
//    }

    @PostMapping("/redirect")
    public ModelAndView pageRedirect(@RequestParam(required = false,name = "USER_ID") String userId,
                                     @RequestParam(name = "TXN_AMOUNT") String transactionAmount,
                                     @RequestParam(name = "ORDER_ID") String orderId) throws Exception {
        System.out.println("#####------------------------------------------------->");
        System.out.println(userId);
        System.out.println(transactionAmount);
        transactionAmount = transactionAmount.trim().substring(0,transactionAmount.length()-2);
        System.out.println(transactionAmount);
        System.out.println(paytmDetails.getPaytmUrl());
        System.out.println(paytmDetails.getMerchantId());
        System.out.println("#####------------------------------------------------->");
        ModelAndView modelAndView = new ModelAndView("redirect:" + paytmDetails.getPaytmUrl());
        TreeMap<String, String> parameters = new TreeMap<>();
        paytmDetails.getDetails().forEach((k, v) -> parameters.put(k, v));
        parameters.put("MOBILE_NO", environment.getProperty("paytm.mobile"));
        parameters.put("EMAIL", environment.getProperty("paytm.email"));
        parameters.put("ORDER_ID", orderId);
        parameters.put("TXN_AMOUNT", transactionAmount);
        parameters.put("CUST_ID", userId);
        String checkSum = getCheckSum(parameters);
        parameters.put("CHECKSUMHASH", checkSum);
        modelAndView.addAllObjects(parameters);
        return modelAndView;
    }

    @PostMapping(value = "/pgresponse")
    public String getResponseRedirect(HttpServletRequest request, Model model, Principal principal) {

        Map<String, String[]> mapData = request.getParameterMap();
        TreeMap<String, String> parameters = new TreeMap<String, String>();
        mapData.forEach((key, val) -> parameters.put(key, val[0]));
        String paytmChecksum = "";
        if (mapData.containsKey("CHECKSUMHASH")) {
            paytmChecksum = mapData.get("CHECKSUMHASH")[0];
        }
        String result;
        boolean isValideChecksum = false;
        System.out.println("RESULT : "+parameters.toString());
        try {
            isValideChecksum = validateCheckSum(parameters, paytmChecksum);
            if (isValideChecksum && parameters.containsKey("RESPCODE")) {
                if (parameters.get("RESPCODE").equals("01")) {


                    User endUser = userService.findByEmail(principal.getName());
                    User userToRelease = null;
                    for (Long id : endUser.getListOfHiredPeople()) {
                        User temp = appService.getUserById(id);
                        if(temp.getRequestedForEnd()) {
                            userToRelease = temp;
                            break;
                        }
                    }

                    //firstly put the details in both history and then delete from each other

                    // save history of service user
                    List<ServiceHistory> serviceHistoryList;
                    if(userToRelease.getServiceHistories().size() < 1) {
                        serviceHistoryList = new ArrayList<>();
                        System.out.println("create new array service list");
                    } else  {
                        serviceHistoryList = new ArrayList<>(userToRelease.getServiceHistories());
                        System.out.println("used old array service list");
                    }
                    ServiceHistory serviceHistory =
                            new ServiceHistory(
                                    endUser.getFirstName()+" "+endUser.getLastName(),
                                    endUser.getEmail(),userToRelease.getHiredStartTime(),"finished");

                    HireHistory hireHistory =
                            new HireHistory(userToRelease.getFirstName()+" "+userToRelease.getLastName(),
                                    userToRelease.getAbout().getTitle(),userToRelease.getEmail(),userToRelease.getPricing(),userToRelease.getHiredStartTime(),
                                    "finished");

                    serviceHistoryList.add(serviceHistory);
                    userToRelease.setServiceHistories(serviceHistoryList);
                    //delete reference from opponent
                    userToRelease.setStatus(null);
                    userToRelease.setHireStatus(false);
                    userToRelease.setEstimatedTime(null);
                    userToRelease.setRequestedForEnd(false);
                    userToRelease.setConsumerId(null);
                    System.out.println(" service history ---->"+serviceHistoryList.toString());
                    //save the history of end user

                    List<HireHistory> hireHistoryList;
                    if(endUser.getHireHistories().size() < 1) {
                        hireHistoryList = new ArrayList<>();
                        System.out.println("create new array  hire list");
                    } else  {
                        hireHistoryList = new ArrayList<>(endUser.getHireHistories());
                        System.out.println("used old array hire list");
                    }

                    hireHistoryList.add(hireHistory);
                    endUser.setHireHistories(hireHistoryList);
                    System.out.println(" hire history ---->"+hireHistoryList.toString());

                    //delete from your side
                    System.out.println("list of hired people before remove ---------------#"+endUser.getListOfHiredPeople().toString());
                    User finalUserToRelease = userToRelease;
                    endUser.getListOfHiredPeople().removeIf(uid -> uid.equals(finalUserToRelease.getId()));
                    System.out.println("list of hired people after remove ---------------#"+endUser.getListOfHiredPeople().toString());

                    System.out.println("end user detail --------------->"+endUser.toString());
                    System.out.println("service user detail --------------->"+userToRelease.toString());

                    userService.save(userToRelease);
                    userService.save(endUser);
                    result = "Payment Successful";
                } else {
                    result = "Payment failed";
                }
            } else {
                result = "Checksum mismatched";
            }
        } catch (Exception e) {
            result = e.toString();
        }
        model.addAttribute("result",result);
        parameters.remove("CHECKSUMHASH");
        model.addAttribute("parameters",parameters);
        return "payment/report";
    }

    private boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
        return CheckSumServiceHelper.getCheckSumServiceHelper().verifycheckSum(paytmDetails.getMerchantKey(),
                parameters, paytmChecksum);
    }
    private String getCheckSum(TreeMap<String, String> parameters) throws Exception {
        return CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(paytmDetails.getMerchantKey(),
                parameters);
    }

    public long getRandomNumber() {
        return (long) (Math.random() * 1000000L);
    }
}
