package com.xueqi.Intelligent_office.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xueqi.Intelligent_office.dto.JsonMessage;
import com.xueqi.Intelligent_office.model.Attendance;
import com.xueqi.Intelligent_office.repository.AttendanceRepository;
import com.xueqi.Intelligent_office.repository.WorkerRepository;
import com.xueqi.Intelligent_office.service.serviceinfo.FDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class AttendanceService implements FDService{

    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private WorkerRepository workerRepository;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected final ObjectMapper objectMapper = new ObjectMapper();

    public Object create(int worker_id,int state) {
        if (workerRepository.findById(worker_id).isPresent()) {
            Attendance attendance = new Attendance(worker_id, state);
            return attendanceRepository.save(attendance);
        }else
            return  new JsonMessage(-1,"the worker is not found !");
    }

    public Object updateState(int id ,int state) {
        Optional<Attendance> attendance = attendanceRepository.findById(id);
        if (attendance.isPresent()) {
            Attendance a = attendance.get();
            logger.info("new state: " + a.getState());
            return attendanceRepository.save(a);
        }else
            return new JsonMessage(-1,"not found");
    }
    @Override
    public Object delete(int id) {
        Attendance attendance = attendanceRepository.findById(id).get();
        attendanceRepository.delete(attendance);
        return new JsonMessage(1,"success");
    }

    @Override
    public Object findAll() {
        return attendanceRepository.findAll();
    }

    @Override
    public Object findOne(int id) {
        //试一下返回类型为 Optional的
        if (attendanceRepository.findById(id).isPresent()){
            return attendanceRepository.findById(id).get();
        }else
            return new JsonMessage(-1,"not found");
    }

    @Override
    public boolean isPresent(int id) {
        return attendanceRepository.findById(id).isPresent();
    }
}
