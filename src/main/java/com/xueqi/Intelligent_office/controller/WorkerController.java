package com.xueqi.Intelligent_office.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.xueqi.Intelligent_office.dto.JsonMessage;
import com.xueqi.Intelligent_office.dto.WorkerDto;
import com.xueqi.Intelligent_office.model.Worker;
import com.xueqi.Intelligent_office.service.DepartmentService;
import com.xueqi.Intelligent_office.service.WorkerService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;
    @Autowired
    private DepartmentService departmentService;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected final ObjectMapper objectMapper = new ObjectMapper();

    @ApiOperation(value = "创建新的员工", notes = "")
    @PostMapping("/create")
    public Object create(@RequestBody @ApiParam(name = "worker", value = "department",required = true) WorkerDto worker/*String name,String tele,Integer department_id,String head, String birthday*/) {
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
}

