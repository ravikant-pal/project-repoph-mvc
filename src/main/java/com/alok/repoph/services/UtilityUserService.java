package com.alok.repoph.services;

import com.alok.repoph.exception.UserAlreadyHiredException;
import com.alok.repoph.models.UtilityUser;
import com.alok.repoph.pojo.ApiResponse;
import com.alok.repoph.repository.UtilityUserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class UtilityUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UtilityUserService.class);

    @Autowired
    UtilityUserDetailService utilityUserDetailService;

    @Autowired
    UtilityUserDao utilityUserDao;

    public ApiResponse selectPeople(Long id, Principal principal) throws Exception {
        LOGGER.info(">>>>Entering into selectPeople ");
        UtilityUser userWithID = utilityUserDao.findById(id).get();

        String message="";
        System.out.println(userWithID.getHireStatus());
        if(!userWithID.getHireStatus()) {
            UtilityUser loggedInUser = utilityUserDao.findByEmail(principal.getName());
            List<UtilityUser> listOfHiredPeople = loggedInUser.getListOfHiredPeople();
            listOfHiredPeople.add(userWithID);
            userWithID.setHireStatus(true);

            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.HOUR, -1);
            Date oneHourBack = cal.getTime();
            userWithID.setHireTime(oneHourBack);
             message = "User selected successfully !";
        }
        else  {
            throw new UserAlreadyHiredException("User already hired for this much period of time ");
        }

        return new ApiResponse(HttpStatus.OK, "success", message);

    }

    public UtilityUser findByEmail(String email) {
        return utilityUserDao.findByEmail(email);
    }

    public List<UtilityUser> findAllUtilityUsers() {
        return utilityUserDao.findAllByRole("SERVICE_USER");
    }

}
