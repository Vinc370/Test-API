package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tr_attendance")
public class Attendance {
    @Id
    private int attendance_ID;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee Employee;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department Department;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region Region;

    private String attendance_Date;
    private String clock_In;
    private String clock_Out;
    private int work_hour;

    public Attendance(){

    }

    public Attendance(
        Employee Employee,
        Department Department,
        Region Region,
        String attendance_Date,
        String clock_In,
        String clock_Out,
        int work_hour
        )
    {
        setEmployeeID(Employee);
        setDepartmentID(Department);
        setRegionID(Region);
        setAttendanceDate(attendance_Date);
        setClockIn(clock_In);
        setClockOut(clock_Out);
        setWorkHour(work_hour);
    }

    public Department getDepartmentID() {
        return Department;
    }

    public void setDepartmentID(Department Department) {
        this.Department = Department;
    }

    public Region getRegionID() {
        return Region;
    }

    public void setRegionID(Region Region) {
        this.Region = Region;
    }

    public String getAttendanceDate() {
        return attendance_Date;
    }

    public void setAttendanceDate(String attendance_Date) {
        this.attendance_Date = attendance_Date;
    }

    public String getClockIn() {
        return clock_In;
    }

    public void setClockIn(String clock_In) {
        this.clock_In = clock_In;
    }

    public String getClockOut() {
        return clock_Out;
    }

    public void setClockOut(String clock_Out) {
        this.clock_Out = clock_Out;
    }

    public int getWorkHour() {
        return work_hour;
    }

    public void setWorkHour(int work_hour) {
        this.work_hour = work_hour;
    }

    public Employee getEmployeeID() {
        return Employee;
    }

    public void setEmployeeID(Employee Employee) {
        this.Employee = Employee;
    }
}
