package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Attendance;
import com.example.demo.Handler.Response;
import com.example.demo.Services.AttendanceService;

@RestController
@RequestMapping("api")
public class AttendanceRestController {
    @Autowired
    private AttendanceService<Attendance> attendanceService;

    @GetMapping("Attendance")
    public ResponseEntity<Object> getAll(){
        //return attendanceService.getAll();
        return Response.generate(HttpStatus.OK, "data retrieved", attendanceService.getAll());
    }

    @GetMapping("Attendance/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id){
        //return attendanceService.Get(id);
        return Response.generate(HttpStatus.OK, "data retrieved", attendanceService.Get(id));
    }

    @PostMapping("Attendance")
    public ResponseEntity<Object> post(@RequestBody Attendance attendance){
        attendanceService.Insert(attendance);
        return Response.generate(HttpStatus.OK, "data retrieved");
    }

    @DeleteMapping("Attendance/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id){
        attendanceService.Delete(id);
        return Response.generate(HttpStatus.OK, "data retrieved");
    }
}
