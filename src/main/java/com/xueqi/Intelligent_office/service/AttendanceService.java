package com.xueqi.Intelligent_office.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xueqi.Intelligent_office.dto.AttendanceDto;
import com.xueqi.Intelligent_office.dto.JsonMessage;
import com.xueqi.Intelligent_office.dto.WorkerDto;
import com.xueqi.Intelligent_office.model.Attendance;
import com.xueqi.Intelligent_office.model.Worker;
import com.xueqi.Intelligent_office.repository.AttendanceRepository;
import com.xueqi.Intelligent_office.repository.DepartmentRepository;
import com.xueqi.Intelligent_office.repository.WorkerRepository;
import com.xueqi.Intelligent_office.service.serviceinfo.FDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import java.util.Optional;

@Service
public class AttendanceService implements FDService {

    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected final ObjectMapper objectMapper = new ObjectMapper();

    public Object create(int worker_id, int state) {
        if (workerRepository.findById(worker_id).isPresent()) {
            Worker worker = workerRepository.findById(worker_id).get();
            Attendance attendance = new Attendance(
                    worker_id,//签到员工id
                    state,//签到状态
                    worker.getDepartment_id()//签到员工所在部门
            );
            attendanceRepository.save(attendance);
            return new AttendanceDto(
                    attendance,
                    departmentRepository.findById(attendance.getDepartmentId()).get().getName()
            );
        } else
            return new JsonMessage(-1, "the worker is not found !");
    }

    public Object updateState(int id, int state) {
        Optional<Attendance> attendance = attendanceRepository.findById(id);
        if (attendance.isPresent()) {
            Attendance a = attendance.get();
            logger.info("new state: " + a.getState());
            return attendanceRepository.save(a);
        } else
            return new JsonMessage(-1, "not found");
    }

    /*本方法存在缺陷：无法查找相应日期的记录*/
    public Object departmentCheck(int departmentId) {
        if (departmentRepository.findById(departmentId).isPresent())
            return attendanceRepository.findAllByDepartmentId(departmentId);
        else
            return new JsonMessage(-1, "departmentId not find");
    }

    /*查看单个员工的签到记录*/
    public Object workerCheck(int workId) {
        if (workerRepository.findById(workId).isPresent()) {
            return attendanceRepository.findAllByWorkerId(workId);
        } else
            return new JsonMessage(-1, "workId not find");
    }

    @Override
    public Object delete(int id) {
        Attendance attendance = attendanceRepository.findById(id).get();
        attendanceRepository.delete(attendance);
        return new JsonMessage(1, "success");
    }

    @Override
    public Object findAll() {
        return attendanceRepository.findAll();
    }

    @Override
    public Object findOne(int id) {
        //试一下返回类型为 Optional的
        if (attendanceRepository.findById(id).isPresent()) {
            return attendanceRepository.findById(id).get();
        } else
            return new JsonMessage(-1, "not found");
    }

    @Override
    public boolean isPresent(int id) {
        return attendanceRepository.findById(id).isPresent();
    }

    @Override
    public Object save(Object o) {
        Attendance attendance = (Attendance) o;
        if (this.isPresent(attendance.getId()))
            return attendanceRepository.save(attendance);
        else
            return null;
    }
}
