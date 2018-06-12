package com.xueqi.Intelligent_office;

import com.xueqi.Intelligent_office.model.Department;
import com.xueqi.Intelligent_office.repository.DepartmentRepository;
import com.xueqi.Intelligent_office.service.Judge;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
public class DepartmentTest {
//    @Autowired
//    private DepartmentRepository repository;
//
    @Test
    public void test(){
        System.out.println(Judge.timeOnDay(1528423820676L,1527242086043L));
    }
}
