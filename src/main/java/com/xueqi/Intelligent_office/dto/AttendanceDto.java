package com.xueqi.Intelligent_office.dto;

import com.xueqi.Intelligent_office.model.Attendance;
import io.swagger.annotations.ApiModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
/**
 *  *  state:本次签到的状态
 *         0 ：未到
 *         1 ：正常到岗
 *         2 ：离开岗位
 *         3 ：请假
 *         4 ：出外勤
*/
@ApiModel(value = "attendance")
@Component
public class AttendanceDto {
    private int workerId;
    private String date;
    private String state;
    private String department;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public AttendanceDto(int workerId, long date, int state, String department) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.workerId = workerId;
        this.date = simpleDateFormat.format(date);
        this.department = department;
        switch (state){
            case 0:
                this.state = "absence";
                break;
            case 1:
                this.state = "normal";
                break;
            case 2:
                this.state = "beOut";
                break;
            case 3:
                this.state = "leave";
                break;
            case 4:
                this.state = "workOutside";
                break;
        }
    }

    public AttendanceDto(Attendance attendance,String department) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.workerId = attendance.getWorkerId();
        this.date = simpleDateFormat.format(attendance.getDate());
        System.out.println(attendance.getDepartmentId());
        this.department = department;
        switch (attendance.getState()){
            case 0:
                this.state = "absence";
                break;
            case 1:
                this.state = "normal";
                break;
            case 2:
                this.state = "beOut";
                break;
            case 3:
                this.state = "leave";
                break;
            case 4:
                this.state = "workOutside";
                break;
        }
    }

    public AttendanceDto() {
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(long date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.date = simpleDateFormat.format(date);
    }

    public String getState() {
        return state;
    }

    public void setState(int state) {
        switch (state){
            case 0:
                this.state = "absence";
                break;
            case 1:
                this.state = "normal";
                break;
            case 2:
                this.state = "beOut";
                break;
            case 3:
                this.state = "leave";
                break;
            case 4:
                this.state = "workOutside";
                break;
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
