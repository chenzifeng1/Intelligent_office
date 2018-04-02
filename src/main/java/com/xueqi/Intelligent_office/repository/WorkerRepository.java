package com.xueqi.Intelligent_office.repository;

import com.xueqi.Intelligent_office.model.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface WorkerRepository extends CrudRepository<Worker,Integer> {
    Iterable<Worker> findAllByDepartment_id = null;
    Iterable<Worker> findAllByName = null;
}
