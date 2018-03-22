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

    private int worker_id;
    private long date;
    private int state;

    public Attendance(int worker_id,int state) {
        this.worker_id = worker_id;
        this.date = System.currentTimeMillis();
        this.state = state;
    }

    public Attendance() {
    }

    public int getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
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
}
