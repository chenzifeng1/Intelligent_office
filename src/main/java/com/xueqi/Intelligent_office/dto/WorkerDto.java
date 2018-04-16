package com.xueqi.Intelligent_office.dto;

import com.xueqi.Intelligent_office.model.Worker;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "worker")
public class WorkerDto {
    private String name;
    private String tele;
    private int department_id;
    private String head;
    private String birthday;

    public WorkerDto(String name, String tele, int department_id, String head, String birthday) {
        this.name = name;
        this.tele = tele;
        this.department_id = department_id;
        this.head = head;
        this.birthday = birthday;
    }

    public WorkerDto(Worker worker) {
        this.name = worker.getName();
        this.tele = worker.getTele();
        this.department_id = worker.getDepartment_id();
        this.head = worker.getHead();
        this.birthday =worker.getBirthday();
    }

    public WorkerDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
