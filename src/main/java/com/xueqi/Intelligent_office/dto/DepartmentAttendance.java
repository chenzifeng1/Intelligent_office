package com.xueqi.Intelligent_office.dto;

public class DepartmentAttendance {

    private  int department_id;
    private  int worker_id;
    private  int total_number;

    public DepartmentAttendance(int department_id, int worker_id, int total_number) {
        this.department_id = department_id;
        this.worker_id = worker_id;
        this.total_number = total_number;
    }

    public DepartmentAttendance() {
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }
}
