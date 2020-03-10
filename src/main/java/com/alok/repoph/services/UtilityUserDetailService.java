package com.alok.repoph.services;


import com.alok.repoph.models.UtilityUser;
import com.alok.repoph.repository.UtilityUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UtilityUserDetailService implements UserDetailsService {
    @Autowired
    private UtilityUserDao utilityUserDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UtilityUser utilityUser = utilityUserDao.findByEmail(email);
        if(utilityUser ==null) {
            throw  new UsernameNotFoundException("Author 404!");
        }
        return new UtilityUserDetailImp(utilityUser.getEmail(), utilityUser.getPassword(), utilityUser.getRole());
    }
}
