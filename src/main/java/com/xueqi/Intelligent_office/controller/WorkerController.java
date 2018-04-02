package com.xueqi.Intelligent_office.controller;


import com.xueqi.Intelligent_office.dto.JsonMessage;
import com.xueqi.Intelligent_office.service.DepartmentService;
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
@RequestMapping("/worker")
public class WorkerController  {

    @Autowired
    private WorkerService workerService;
    @Autowired
    private DepartmentService departmentService;

    @ApiOperation(value = "创建新的员工",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "员工名称",required = true,dataType = "String"),
            @ApiImplicitParam(name = "tele",value = "员工电话",required = true,dataType = "String"),
            @ApiImplicitParam(name = "department_id",value = "部门id",required = true,dataType = "int"),
            @ApiImplicitParam(name = "head",value = "员工头像",required = true,dataType = "String"),
            @ApiImplicitParam(name = "birthday",value = "员工生日",required = true,dataType = "String")
    })
    @PostMapping("/create")
    public Object create(String name,String tele,int department_id,String head, String birthday){
        if (!departmentService.isPresent(department_id)){
            return new JsonMessage(-1,"no department");
        }
        return workerService.create(name,tele,department_id,head,birthday);
    }

    @ApiOperation(value = "查找员工",notes = "")
    @ApiImplicitParam(name = "id",value = "员工id",required = true,dataType = "int")
    @GetMapping("/findOne")
    public Object findOne(int id){
        return workerService.findOne(id);
    }

    @ApiOperation(value = "删除员工",notes = "")
    @ApiImplicitParam(name = "id",value = "员工id",required = true,dataType = "int")
    @PostMapping("/delete")
    public Object delete(int id){
       return workerService.delete(id);
    }
//    @GetMapping("/sign")
//    public Object sign(int worker_id){
//        return workerService.checkSign(worker_id);
//    }
}

