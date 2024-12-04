package com.college.collegeProject.AdminController;


import com.college.collegeProject.AdminService.HomeService;
import com.college.collegeProject.Model.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/home")
    public List<Msg> home(){
        return homeService.getallmsg();
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello wrl?111";
    }
}
