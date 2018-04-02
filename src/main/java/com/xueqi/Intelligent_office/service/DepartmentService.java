package com.xueqi.Intelligent_office.service;

import com.xueqi.Intelligent_office.dto.JsonMessage;
import com.xueqi.Intelligent_office.model.Department;
import com.xueqi.Intelligent_office.repository.DepartmentRepository;
import com.xueqi.Intelligent_office.service.serviceinfo.FDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService implements FDService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Object create(String name,String boss,int num){
        Department department = new Department(name,boss,num);
        return departmentRepository.save(department);
    }

    public boolean departmentIsExist(String name){
        if(departmentRepository.findByName(name).isPresent()){
            return true;
        }
        else
            return false;
    }

    @Override
    public Object delete(int id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()){
            departmentRepository.delete(department.get());
            return new JsonMessage(1,"success");
        }else
            return new JsonMessage(-1,"not found");
    }

    @Override
    public Object findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Object findOne(int id) {
        if (departmentRepository.findById(id).isPresent())
            return departmentRepository.findById(id).get();
        else
            return new JsonMessage(-1,"not found");
    }

    @Override
    public boolean isPresent(int id) {
        return departmentRepository.findById(id).isPresent();
    }


}
