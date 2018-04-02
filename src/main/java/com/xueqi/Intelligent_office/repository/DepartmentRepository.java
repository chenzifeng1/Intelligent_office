package com.xueqi.Intelligent_office.repository;

import com.xueqi.Intelligent_office.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Integer>{
    Optional<Department> findByName(String name);
}
