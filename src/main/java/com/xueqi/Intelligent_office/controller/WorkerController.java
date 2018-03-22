package com.xueqi.Intelligent_office.controller;


import com.xueqi.Intelligent_office.dto.JsonMessage;
import com.xueqi.Intelligent_office.service.DepartmentService;
import com.xueqi.Intelligent_office.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worker")
public class WorkerController  {

    @Autowired
    WorkerService workerService;
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/create")
    public Object create(String name,String tele,int department_id,String head, String birthday){
        if (departmentService.findOne(department_id)==null){
            return new JsonMessage(-1,"no department");
        }
        return workerService.create(name,tele,department_id,head,birthday);
    }

}

