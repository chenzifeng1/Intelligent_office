package com.xueqi.Intelligent_office.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xueqi.Intelligent_office.dto.JsonMessage;
import com.xueqi.Intelligent_office.model.Worker;
import com.xueqi.Intelligent_office.repository.AttendanceRepository;
import com.xueqi.Intelligent_office.repository.DepartmentRepository;
import com.xueqi.Intelligent_office.repository.WorkerRepository;
import com.xueqi.Intelligent_office.service.serviceinfo.FDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class WorkerService implements FDService {

    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private AttendanceRepository attendanceRepository;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected final ObjectMapper objectMapper = new ObjectMapper();

    public Object create(String name,String tele,int department_id,String head, String birthday) {
        if (departmentRepository.findById(department_id).isPresent()) {
            Worker worker = new Worker(name, tele, department_id, head, birthday);
            return workerRepository.save(worker);
        }else
            return new JsonMessage(-1,"the department is not found ");
    }
    @Override
    public Object delete(int id) {
       Optional<Worker> worker = workerRepository.findById(id);
       if (worker.isPresent()){
           logger.info("delete : "+worker.get().getName());
           workerRepository.delete(worker.get());
           return new JsonMessage(1,"success");
       }
       else
           return new JsonMessage(-1,"the worker is not find");

    }

    @Override
    public Object findAll() {
        return workerRepository.findAll();
    }

    @Override
    public Object findOne(int id) {
        //注意id的判断
        if (workerRepository.findById(id).isPresent())
            return workerRepository.findById(id).get();
        else
            return new JsonMessage(-1,"not found");
    }

    @Override
    public boolean isPresent(int id) {
        return workerRepository.findById(id).isPresent();
    }

//    public Object checkSign(int worker_id){
//        return attendanceRepository.findFirstByWorker_idOrderByDateDesc(worker_id);
//    }
}
