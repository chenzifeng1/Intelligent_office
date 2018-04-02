package com.xueqi.Intelligent_office.repository;

import com.xueqi.Intelligent_office.model.Attendance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance,Integer> {

   // Iterable<Attendance> findFirstByWorker_idOrderByDateDesc(int worker_id);
}
