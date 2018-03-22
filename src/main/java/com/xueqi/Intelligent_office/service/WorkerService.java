package com.xueqi.Intelligent_office.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xueqi.Intelligent_office.dto.JsonMessage;
import com.xueqi.Intelligent_office.model.Worker;
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
    WorkerRepository workerRepository;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected final ObjectMapper objectMapper = new ObjectMapper();

    public Object create(String name,String tele,int department_id,String head, String birthday){
        Worker worker = new Worker(name,tele,department_id,head,birthday);
        return workerRepository.save(worker);
    }

    @Override
    public Object delete(int id) {
       Optional<Worker> worker = workerRepository.findById(id);
        workerRepository.delete(worker.get());
        return new JsonMessage(1,"success");
    }

    @Override
    public Object findAll() {
        return workerRepository.findAll();
    }

    @Override
    public Object findOne(int id) {
        return workerRepository.findById(id).get();
    }

}
