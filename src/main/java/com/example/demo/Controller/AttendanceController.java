package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.Attendance;
import com.example.demo.Services.AttendanceService;

@Controller
@RequestMapping("attendance")
public class AttendanceController {
    
    @Autowired
    private AttendanceService<Attendance> attendanceService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("attendance", attendanceService.getAll());
        return "attendance/index";
    }

    @GetMapping(value = {"form"})
    public String form(Model model){
        model.addAttribute("attendance", new Attendance());
        model.addAttribute("attendances", attendanceService.getAll());
        return "attendance/form";
    }

    @PostMapping("save")
    public String submit(Attendance attendance){
        Boolean result = attendanceService.Insert(attendance);
        if (result){
            return "redirect:/attendance";
        }
        else{
            return "attendance/form";
        }
    }
}
