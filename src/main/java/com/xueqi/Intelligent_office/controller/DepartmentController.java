package com.xueqi.Intelligent_office.controller;

import com.xueqi.Intelligent_office.dto.JsonMessage;
import com.xueqi.Intelligent_office.model.Department;
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

    @PostMapping("/create")
    @ApiOperation(value = "创建新的部门", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "部门名称", required = true, paramType =  "query",dataType = "String"),
            @ApiImplicitParam(name = "boss", value = "部门主管", required = true,paramType =  "query", dataType = "String"),
            @ApiImplicitParam(name = "num", value = "部门人数", required = true,paramType =  "query", dataType = "Integer"),
    })
    public Object create(String name, String boss, Integer num) {
        if (num < 0)
            return new JsonMessage(-1, "information is error");
        if (departmentService.departmentIsExist(name))
            return new JsonMessage(-2, "the department has existed");
        return departmentService.create(name, boss, num);
    }

    @PostMapping("/updateBoss")
    @ApiOperation(value = "修改部门主管", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departmentId", value = "部门id", required = true, paramType =  "query",dataType = "Integer"),
            @ApiImplicitParam(name = "boss", value = "部门主管", required = true,paramType =  "query", dataType = "String")
    })
    public Object updateBoss(Integer departmentId, String boss) {
        if (departmentService.isPresent(departmentId)) {
            Department department = (Department) departmentService.findOne(departmentId);
            department.setBoss(boss);
            return departmentService.save(department);
        } else
            return new JsonMessage(-1, "Id not find");
    }

    @PostMapping("/updateNum")
    @ApiOperation(value = "修改部门人数", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departmentId", value = "部门id", required = true, paramType =  "query",dataType = "int"),
            @ApiImplicitParam(name = "num", value = "部门人数", required = true,paramType =  "query", dataType = "int")
    })
    public Object updateNum(int departmentId, int num) {
        if (departmentService.isPresent(departmentId)) {
            Department department = (Department) departmentService.findOne(departmentId);
            if (num>0){
                department.setNum(num);
                return departmentService.save(department);
            }else
                return new JsonMessage(-1,"num is wrong");
        }
        return new JsonMessage(-1,"id not find");
    }

}
