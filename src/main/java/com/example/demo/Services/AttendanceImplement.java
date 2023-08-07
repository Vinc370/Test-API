package com.example.demo.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Attendance;
import com.example.demo.Repository.AttendanceRepository;

@Service
public class AttendanceImplement implements AttendanceService<com.example.demo.Entity.Attendance>{

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public Boolean Insert(Attendance model) {
        attendanceRepository.save(model);
        return true;
    }

    @Override
    public Boolean Update(Attendance model) {
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public Boolean Delete(int model) {
        throw new UnsupportedOperationException("Unimplemented method 'Delete'");
    }

    @Override
    public List<Attendance> getAll() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance Get(int model) {
        throw new UnsupportedOperationException("Unimplemented method 'Get'");
    }
}
