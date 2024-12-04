package com.college.collegeProject.AdminController;


import com.college.collegeProject.AdminService.adminService;
import com.college.collegeProject.Model.Admin;
import com.college.collegeProject.Model.Msg;
import com.college.collegeProject.SecurityConfig.filter.jwtservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private adminService service;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private jwtservice jwt_service;

    @PostMapping("addadmin")
    public void admin(@RequestBody Admin admin){
        service.addadmin(admin);
    }

    @PostMapping("/login")
    public String login(@RequestBody Admin admin){
        Authentication auth = manager.authenticate(new UsernamePasswordAuthenticationToken(admin.getUsername(),admin.getPassword()));
        if(auth.isAuthenticated()){
            return jwt_service.generatetoken(admin.getUsername());
        }
        else {
            return "";
        }
    }

    @PostMapping("addmsg")
    public void addmsg(@RequestBody Msg msg){
        service.addmsg(msg);
    }

    @DeleteMapping("addmsg/{id}")
    public void delmsg(@PathVariable("id") int id){
        service.deletemsg(id);
    }

    @PutMapping("updatemsg/{id}")
    public void updatemsg(@PathVariable("id") int id, @RequestBody Msg msg){
        service.upmsg(id,msg);
    }
}
