package com.xueqi.Intelligent_office.model;


import javax.persistence.*;

/**
 *  date :员工签到成功的时间戳
 *  state:本次签到的状态
 *         0 ：未到
 *         1 ：正常到岗
 *         2 ：离开岗位
 *         3 ：请假
 *         4 ：出外勤
 * */
@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int workerId;
    private long date;
    private int state;
    private int departmentId;

    public Attendance(int workerId, int state, int departmentId) {
        this.workerId = workerId;
        this.date = System.currentTimeMillis();
        this.state = state;
        this.departmentId = departmentId;
    }

    public Attendance() {
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
