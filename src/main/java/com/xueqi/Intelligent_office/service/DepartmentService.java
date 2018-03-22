package com.xueqi.Intelligent_office.service;

import com.xueqi.Intelligent_office.dto.JsonMessage;
import com.xueqi.Intelligent_office.model.Department;
import com.xueqi.Intelligent_office.repository.DepartmentRepository;
import com.xueqi.Intelligent_office.service.serviceinfo.FDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService implements FDService {

    @Autowired
    DepartmentRepository departmentRepository;

    public Object create(String name,String boss,int num){
        Department department = new Department(name,boss,num);
        return departmentRepository.save(department);
    }

    public boolean departmentIsExist(String name){
        if(departmentRepository.findByName(name)!=null){
            return true;
        }
        else
            return false;
    }

    @Override
    public Object delete(int id) {
        Department department = departmentRepository.findById(id).get();
        departmentRepository.delete(department);
        return new JsonMessage(1,"success");
    }

    @Override
    public Object findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Object findOne(int id) {
        return departmentRepository.findById(id).get();
    }

}
