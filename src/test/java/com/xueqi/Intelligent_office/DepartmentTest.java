package com.xueqi.Intelligent_office;

import com.xueqi.Intelligent_office.model.Department;
import com.xueqi.Intelligent_office.repository.DepartmentRepository;
import com.xueqi.Intelligent_office.service.Judge;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;


@SpringBootTest
public class DepartmentTest {
//    @Autowired
//    private DepartmentRepository repository;
//
    @Test
    public void test(){
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        long aim = 1528423820676L ;
        long currnent = 1527242086043L;

        String day1 = s.format(aim);
        String day2 = s.format(currnent);
        System.out.println(day1);
        System.out.println(day2);
        System.out.println(Judge.timeOnDay(aim,currnent));
    }

    @Test
    public void phoneTest(){
        String phone = "1780620750";
        System.out.println("输入为："+phone);
        System.out.println("输出为：" +Judge.isPhone(phone));
    }
}
