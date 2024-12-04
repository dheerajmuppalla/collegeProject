package com.college.collegeProject.Repository;

import com.college.collegeProject.Model.Msg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MsgRepo extends JpaRepository<Msg,Integer> {
}
