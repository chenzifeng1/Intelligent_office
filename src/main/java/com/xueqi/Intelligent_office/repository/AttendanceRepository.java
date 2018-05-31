package com.xueqi.Intelligent_office.repository;

import com.xueqi.Intelligent_office.model.Attendance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance,Integer> {

  // Attendance findFirstByWorker_id(int worker_id);
   Iterable<Attendance> findAllByDepartmentId(int departmentId);
   Iterable<Attendance> findAllByWorkerId(int workerId);
   Attendance findFirstByWorkerIdOrderByDateDesc(int workerid);
}
