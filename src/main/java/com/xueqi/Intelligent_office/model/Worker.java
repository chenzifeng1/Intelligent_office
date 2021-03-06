package com.xueqi.Intelligent_office.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;

@Entity
@Table(name = "worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String tele;
    private int department_id;
    private String head;
    private String birthday;

    public Worker(String name, String tele, int department_id, String head, String birthday) {
        this.name = name;
        this.tele = tele;
        this.department_id = department_id;
        this.head = head;
        this.birthday = birthday;
    }

    public Worker() {
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

    public int getId() {
        return id;
    }

    public void print(){
        System.out.println("Name : " + this.getName()+"\n"
        +"Head ：" + this.getHead()+"\n"
        +"Birthday : " + this.getBirthday()+"\n"
        +"department_id : "+ this.getDepartment_id());
    }
}
