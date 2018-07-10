package com.xueqi.Intelligent_office.security.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends  CrudRepository<User,Integer> {
    User findFirstById(int id);
    User findFirstByUsername(String username);
    User findFirstByEmail(String email);
}
