package com.xueqi.Intelligent_office.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.xueqi.Intelligent_office.dto.JsonMessage;
import com.xueqi.Intelligent_office.dto.WorkerDto;
import com.xueqi.Intelligent_office.model.Worker;
import com.xueqi.Intelligent_office.service.DepartmentService;
import com.xueqi.Intelligent_office.service.FileService;
import com.xueqi.Intelligent_office.service.WorkerService;
import com.xueqi.Intelligent_office.util.FileUtil;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private FileService fileService;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected final ObjectMapper objectMapper = new ObjectMapper();

    @ApiOperation(value = "创建新的员工", notes = "")
    @PostMapping(value = "/create")
    public Object create(@RequestBody @ApiParam(name = "worker", value = "员工",required = true) WorkerDto worker) {


        try {
            logger.info("WorkerController.name:" + worker.getName());
            logger.info("WorkerController.department_id :" + worker.getDepartment_id());

        } catch (Exception e) {
            logger.info("department_id is null ???????");
            e.printStackTrace();
        }
        logger.info("开始创建员工");
        return workerService.create(
                worker.getName(),
                worker.getTele(),
                worker.getDepartment_id(),
                worker.getHead(),
                worker.getBirthday()
        );
    }

    @ApiOperation(value = "查找员工", notes = "")
    @ApiImplicitParam(name = "id", value = "员工id", required = true, paramType = "query", dataType = "integer")
    @GetMapping("/findOne")
    public Object findOne(Integer id) {
        return workerService.findOne(id);
    }

    @ApiOperation(value = "删除员工", notes = "")
    @ApiImplicitParam(name = "id", value = "员工id", required = true, paramType = "query", dataType = "integer")
    @PostMapping("/delete")
    public Object delete(Integer id) {
        return workerService.delete(id);
    }

    @ApiOperation(value = "全体员工信息",notes = "")
    @GetMapping("/findAll")
    public Object findAll(){
        return workerService.findAll();
    }

    @ApiOperation(value = "根据姓名查找员工",notes = "")
    @ApiImplicitParam(name = "name" ,value = "员工姓名",required = true,paramType = "query",dataType = "string")
    @GetMapping("/findByName")
    public Object findByName(String name){
        return workerService.findByName(name);
    }

    @ApiOperation(value = "上传员工图片",notes = "")
    @PostMapping(value = "/file",consumes = "multipart/*",headers = "content-type=multipart/form-data")
    @ApiImplicitParam(name = "workId",value = "员工ID",required = true,paramType = "query",dataType = "Integer")
    public Object fileUpload(@ApiParam(value = "员工图片" ,required = true)MultipartFile file
            ,HttpServletRequest request,Integer workId) {
        String f = fileService.fileUpload(file,request);
        if (f.equals("file upload failure,because the file is null")){
            return new JsonMessage(-1,f);
        }
        Worker worker = (Worker) workerService.findOne(workId);
        worker.setHead(f);
        return workerService.save(worker);
    }
}

