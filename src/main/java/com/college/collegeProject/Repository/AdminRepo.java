package com.college.collegeProject.Repository;

import com.college.collegeProject.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepo extends JpaRepository<Admin, String> {
    Admin findByusername(String username);
}
