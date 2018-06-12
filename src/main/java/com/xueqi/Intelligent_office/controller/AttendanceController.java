package com.xueqi.Intelligent_office.controller;

import com.xueqi.Intelligent_office.dto.JsonMessage;
import com.xueqi.Intelligent_office.model.Attendance;
import com.xueqi.Intelligent_office.model.Worker;
import com.xueqi.Intelligent_office.service.AttendanceService;
import com.xueqi.Intelligent_office.service.WorkerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;
    @Autowired
    WorkerService workerService;

    @PostMapping("/sign")
    @ApiOperation(value = "员工签到", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workId", value = "员工id", required = true,paramType =  "query", dataType = "Integer"),
            @ApiImplicitParam(name = "state", value = "签到状态", required = true,paramType =  "query", dataType = "Integer")
    })
    public Object sign(Integer workId, Integer state) {
        return attendanceService.create(workId, state);
    }

    @GetMapping("/checkDepartment")
    @ApiOperation(value = "查看部门签到记录", notes = "暂时无法按时间查找")
    @ApiImplicitParam(name = "departmentId", value = "部门id", required = true, paramType =  "query",dataType = "Integer")
    public Object checkDepartment(Integer departmentId) {
        return attendanceService.departmentCheck(departmentId);
    }

    @GetMapping("/checkWorker")
    @ApiOperation(value = "查看某个员工的签到记录",notes = "")
    @ApiImplicitParam(name = "workId",value = "员工Id",required = true,paramType = "query",dataType = "Integer")
    public Object checkWorker(Integer workId){
        return attendanceService.workerCheck(workId);
    }

    @PostMapping("/signByName")
    @ApiOperation(value = "根据员工的姓名签到",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "员工姓名",required = true,dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "state",value = "状态",required = true,dataType = "Integer",paramType = "query")
    })
    public Object signByName(String name,Integer state){
        return attendanceService.signByName(name,state);
    }
}
