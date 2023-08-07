package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer>{
    
}
