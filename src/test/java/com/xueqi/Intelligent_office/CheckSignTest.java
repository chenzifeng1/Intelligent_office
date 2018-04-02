package com.xueqi.Intelligent_office;

import com.xueqi.Intelligent_office.model.Worker;
import com.xueqi.Intelligent_office.service.WorkerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
public class CheckSignTest {
    @Autowired
    WorkerService workerService;

//    @Test
//    public void checkSign(){
//        Worker worker = (Worker) workerService.checkSign(1);
//        worker.print();
//    }
}
