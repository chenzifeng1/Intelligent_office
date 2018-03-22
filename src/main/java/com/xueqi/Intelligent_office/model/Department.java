package com.xueqi.Intelligent_office.model;

import javax.persistence.*;

/**
 * boss:部门主管
 * num:该部门员工人数
 * */
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String boss;
    private int num;

    public Department(String name, String boss, int num) {
        this.name = name;
        this.boss = boss;
        this.num = num;
    }

    public Department() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
