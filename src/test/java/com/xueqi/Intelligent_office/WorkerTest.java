package com.xueqi.Intelligent_office;

import com.xueqi.Intelligent_office.model.Worker;
import com.xueqi.Intelligent_office.repository.WorkerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkerTest {
    @Autowired
    WorkerRepository workerRepository;

    @Test
    public void create(){
        workerRepository.save(new Worker("Test", "17806275048",1,"c://czf.jpg","10-02"));
    }
}
