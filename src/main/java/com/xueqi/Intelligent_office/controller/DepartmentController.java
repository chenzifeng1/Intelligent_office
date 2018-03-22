package com.xueqi.Intelligent_office.controller;

import com.xueqi.Intelligent_office.dto.JsonMessage;
import com.xueqi.Intelligent_office.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/create")
    public Object create(String name,String boss,int num){
        if (num<0)
            return new JsonMessage(-1,"information is error");
        if(departmentService.departmentIsExist(name))
            return new JsonMessage(-2,"the department has existed");
        return departmentService.create(name,boss,num);
    }

}
