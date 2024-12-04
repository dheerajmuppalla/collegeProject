package com.college.collegeProject.AdminService;


import com.college.collegeProject.Model.Admin;
import com.college.collegeProject.Model.Msg;
import com.college.collegeProject.Repository.AdminRepo;
import com.college.collegeProject.Repository.MsgRepo;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class adminService {
    @Autowired
    private AdminRepo repo;

    @Autowired
    private MsgRepo msgrepo;

    @Autowired
    private BCryptPasswordEncoder encoder;
    public void addadmin(Admin admin) {
       String pass =  admin.getPassword();
       String encryptpass = encoder.encode(pass);
       admin.setPassword(encryptpass);
        repo.save(admin);
    }

    public void addmsg(Msg msg) {
        msgrepo.save(msg);
    }

    public void deletemsg(int i) {
        Msg m = msgrepo.findById(i).orElse(new Msg());
        msgrepo.delete(m);
    }



    public void upmsg(int id, Msg msg) {
        Msg m = msgrepo.findById(id).orElse(new Msg());
        msgrepo.delete(m);
        msgrepo.save(msg);
    }
}
