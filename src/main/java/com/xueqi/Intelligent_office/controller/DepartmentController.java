package com.xueqi.Intelligent_office.controller;

import com.xueqi.Intelligent_office.dto.JsonMessage;
import com.xueqi.Intelligent_office.service.DepartmentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

//    @PostMapping("/create")
    @ApiOperation(value="创建新的部门", notes="")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "部门名称",required = true,dataType = "String"),
            @ApiImplicitParam(name = "boss",value = "部门主管",required = true,dataType = "String"),
            @ApiImplicitParam(name = "num",value = "部门人数",required = true,dataType = "int"),
    })
    @GetMapping("/create")
    public Object create(String name,String boss,int num){
        if (num<0)
            return new JsonMessage(-1,"information is error");
        if(departmentService.departmentIsExist(name))
            return new JsonMessage(-2,"the department has existed");
        return departmentService.create(name,boss,num);
    }

}
