package com.college.collegeProject.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Admin {
    private int para;
    @Id
    private String username;
    private String password;

    public Admin(int para){
        this.para = para;
    }
}
