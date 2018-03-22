package com.xueqi.Intelligent_office.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xueqi.Intelligent_office.dto.JsonMessage;
import com.xueqi.Intelligent_office.model.Attendance;
import com.xueqi.Intelligent_office.repository.AttendanceRepository;
import com.xueqi.Intelligent_office.service.serviceinfo.FDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;



public class AttendanceService implements FDService{

    @Autowired
    AttendanceRepository attendanceRepository;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected final ObjectMapper objectMapper = new ObjectMapper();

    public Object create(int work_id,int state){
        Attendance attendance = new Attendance(work_id,state);
        return attendanceRepository.save(attendance);
    }

    public Object updataState(int id ,int state){
        Attendance attendance = attendanceRepository.findById(id).get();
        attendance.setState(state);
        logger.info("new state: "+attendance.getState());
        return attendanceRepository.save(attendance);
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
        return attendanceRepository.findById(id);
    }
}
