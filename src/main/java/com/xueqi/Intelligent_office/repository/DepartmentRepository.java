package com.xueqi.Intelligent_office.repository;

import com.xueqi.Intelligent_office.model.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department,Integer>{
    Department findByName(String name);
}
