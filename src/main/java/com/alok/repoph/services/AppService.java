package com.alok.repoph.services;

import com.alok.repoph.models.User;
import com.alok.repoph.pojo.HireHistory;
import com.alok.repoph.pojo.ServiceHistory;
import com.alok.repoph.repository.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
@Transactional
public class AppService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppService.class);

    @Autowired
    UserDao userDao;



//    public ResponseEntity<?> generateAuthenticationToken(AuthenticationRequest authenticationRequest) {
//        LOGGER.info(">>>>> Entering into jwt token generator ");
//        try {
//
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            authenticationRequest.getUsername(),
//                            authenticationRequest.getPassword()
//                    ));
//
//        } catch (BadCredentialsException e) {
//            LOGGER.error(Arrays.toString(e.getStackTrace()));
//            LOGGER.info("<<<<< Exiting from jwt token generator ");
//            return new ResponseEntity<>("Incorrect username or password", HttpStatus.FORBIDDEN);
//        }
//
//
//        final UserDetails userDetails = utilityUserDetailService
//                .loadUserByUsername(authenticationRequest.getUsername());
//
//        final String jwt = jwtTokenUtil.generateToken(userDetails);
//        LOGGER.info("<<<<< Exiting from jwt token generator ");
//        return ResponseEntity.ok(new AuthenticationResponse(jwt));
//    }

//    public String registerUtilityUser(User user) throws Exception {
//        LOGGER.info(">>>>Entering into registerServiceUserController ");
//        User userFromDatabase;
//        userFromDatabase = userDao.findByEmail(user.getEmail());
//        String message = "";
//        if (userFromDatabase != null) {
//            message = "This username already exists! Please try another ";
//            return message;
//        } else {
//            if(user.getRole().equalsIgnoreCase("service")) {
//                user.setRole("SERVICE_USER");
//            }
//            else  {
//                user.setRole("END_USER");
//            }
//            String encryptedPassword = passwordEncoder.encode(user.getPassword());
//            user.setPassword(encryptedPassword);
//            userDao.save(user);
//            message = "You are successfully Registered! Please login ";
//        }
//
//        LOGGER.info("<<<<<Exiting from registerController ");
//        return message;
//    }
    public User getUserById(Long id) {
        return userDao.findById(id).get();
    }

    public List<User> getAllUsers() {
        return userDao.findAllByIsProfileCompleted(true);
    }
    public List<User> getAllUserWhichIsServiceProvider() {
        return userDao.findAllBySpecificRoles("SERVICE_USER",true);
    }

    public String hire(Double estTime,String ids, Principal principal){
        LOGGER.info(">>>>Entering into hire ");
        User endUser = userDao.findByEmail(principal.getName());
        List<Long> hiredUser = new ArrayList<>();
        String[] usersIdsList = ids.split(",");
        Arrays.asList(usersIdsList).forEach(id -> {
            User user = userDao.findById(Long.parseLong(id)).get();
            user.setEstimatedTime(estTime);
            user.setStatus("pending");
            user.setHireStatus(true);
            user.setConsumerId(endUser.getId());
            hiredUser.add(Long.parseLong(id));
        });
        endUser.setListOfHiredPeople(hiredUser);
        String message ="Your hiring is successful !";
        LOGGER.info("<<<<<Exiting from updateAbout ");
        return message;
    }

    public User cancelOrder(Principal principal,Long id) {
        LOGGER.info(">>>>Entering into cancelOrder ");
        User endUser = userDao.findByEmail(principal.getName());
        User serviceUser = userDao.findById(id).get();
        //firstly put the details in both history and then delete from each other

        // save history of service user
        List<ServiceHistory> serviceHistoryList;
        if(serviceUser.getServiceHistories().size() < 1) {
            serviceHistoryList = new ArrayList<>();
            System.out.println("create new array service list");
        } else  {
            serviceHistoryList = new ArrayList<>(serviceUser.getServiceHistories());
            System.out.println("used old array service list");
        }
        ServiceHistory serviceHistory =
                new ServiceHistory(
                        endUser.getFirstName()+" "+endUser.getLastName(),
                        endUser.getEmail(),serviceUser.getHiredStartTime(),"cancel");

        HireHistory hireHistory =
                new HireHistory(serviceUser.getFirstName()+" "+serviceUser.getLastName(),
                        serviceUser.getAbout().getTitle(),serviceUser.getEmail(),serviceUser.getPricing(),serviceUser.getHiredStartTime(),
                        "cancel");

        serviceHistoryList.add(serviceHistory);
        serviceUser.setServiceHistories(serviceHistoryList);
        //delete reference from opponent
        serviceUser.setStatus(null);
        serviceUser.setHireStatus(false);
        serviceUser.setEstimatedTime(null);
        serviceUser.setConsumerId(null);
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
        endUser.getListOfHiredPeople().removeIf(uid -> uid.equals(serviceUser.getId()));
        System.out.println("list of hired people after remove ---------------#"+endUser.getListOfHiredPeople().toString());

        System.out.println("end user detail --------------->"+endUser.toString());
        System.out.println("service user detail --------------->"+serviceUser.toString());

        LOGGER.info("<<<<<Exiting from cancelOrder ");
        return endUser;
    }

    public User declineOrder(Principal principal) {
        LOGGER.info(">>>>Entering into declineOrder ");
        User serviceUser = userDao.findByEmail(principal.getName());
        User endUser = userDao.findById(serviceUser.getConsumerId()).get();
        //firstly put the details in both history and then delete from each other

        // save history of service user
        List<ServiceHistory> serviceHistoryList;
        if(serviceUser.getServiceHistories().size() < 1) {
            serviceHistoryList = new ArrayList<>();
            System.out.println("create new array service list");
        } else  {
            serviceHistoryList = new ArrayList<>(serviceUser.getServiceHistories());
            System.out.println("used old array service list");
        }
        ServiceHistory serviceHistory =
                new ServiceHistory(
                        endUser.getFirstName()+" "+endUser.getLastName(),
                        endUser.getEmail(),serviceUser.getHiredStartTime(),"declined");

        HireHistory hireHistory =
                new HireHistory(serviceUser.getFirstName()+" "+serviceUser.getLastName(),
                        serviceUser.getAbout().getTitle(),serviceUser.getEmail(),serviceUser.getPricing(),serviceUser.getHiredStartTime(),
                        "declined");

        serviceHistoryList.add(serviceHistory);
        serviceUser.setServiceHistories(serviceHistoryList);
        //delete reference from opponent
        serviceUser.setStatus(null);
        serviceUser.setHireStatus(false);
        serviceUser.setEstimatedTime(null);
        serviceUser.setConsumerId(null);
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
        endUser.getListOfHiredPeople().removeIf(uid -> uid.equals(serviceUser.getId()));
        System.out.println("list of hired people after remove ---------------#"+endUser.getListOfHiredPeople().toString());

        System.out.println("end user detail --------------->"+endUser.toString());
        System.out.println("service user detail --------------->"+serviceUser.toString());

        LOGGER.info("<<<<<Exiting from declineOrder ");
        return serviceUser;
    }

//LOGGER.info(">>>>>Entering into cancelController");
//        try {
//        User endUser = userService.findByEmail(principal.getName());
//        User serviceUser = appService.getUserById(id);
//        List<ServiceHistory> serviceHistoryList;
//        if (serviceUser.getServiceHistories().size() < 1) {
//            serviceHistoryList = new ArrayList<>();
//            System.out.println("create new array service list");
//        } else {
//            serviceHistoryList = new ArrayList<>(serviceUser.getServiceHistories());
//            System.out.println("used old array service list");
//        }
//        ServiceHistory serviceHistory =
//                new ServiceHistory(
//                        endUser.getFirstName() + " " + endUser.getLastName(),
//                        endUser.getEmail(), serviceUser.getHiredStartTime(), "cancel");
//
//        HireHistory hireHistory =
//                new HireHistory(serviceUser.getFirstName() + " " + serviceUser.getLastName(),
//                        serviceUser.getAbout().getTitle(), serviceUser.getEmail(), serviceUser.getPricing(), serviceUser.getHiredStartTime(),
//                        "cancel");
//
//        serviceHistoryList.add(serviceHistory);
//        serviceUser.setServiceHistories(serviceHistoryList);
//        serviceUser.setStatus(null);
//        serviceUser.setHireStatus(false);
//        serviceUser.setEstimatedTime(null);
//        serviceUser.setConsumerId(null);
//        userService.save(serviceUser);
//
//        List<HireHistory> hireHistoryList;
//        if (endUser.getHireHistories().size() < 1) {
//            hireHistoryList = new ArrayList<>();
//            System.out.println("create new array  hire list");
//        } else {
//            hireHistoryList = new ArrayList<>(endUser.getHireHistories());
//            System.out.println("used old array hire list");
//        }
//
//        hireHistoryList.add(hireHistory);
//        endUser.setHireHistories(hireHistoryList);
//        endUser.getListOfHiredPeople().removeIf(uid -> uid.equals(serviceUser.getId()));
//        userService.save(endUser);
//
//        User ok = appService.getUserById(endUser.getId());
//        System.out.println("==========>"+ok.toString());
//        LOGGER.info("<<<<<Exiting from cancelController");
//        model.addAttribute("me", ok);
//    } catch (Exception e) {
//        LOGGER.info("<<<<<Exiting from cancelController catch");
//        model.addAttribute("msg", "Something went wrong !");
//        return "order-details";
//    }
//        return "order-details";
}
