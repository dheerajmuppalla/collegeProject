package com.college.collegeProject.AdminService;


import com.college.collegeProject.Model.Msg;
import com.college.collegeProject.Repository.MsgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    @Autowired
    private MsgRepo repo;
    public List<Msg> getallmsg(){
        return repo.findAll();
    }
}
