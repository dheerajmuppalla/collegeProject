package com.college.collegeProject.SecurityConfig;

import com.college.collegeProject.Model.Admin;
import com.college.collegeProject.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class User_detail_service implements UserDetailsService {

    @Autowired
    private AdminRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = repo.findById(username).orElse(new Admin(-1));
        if(admin.getPara()==-1){
            throw new UsernameNotFoundException("User not found");
        }
        return new User_details(admin);

    }
}
