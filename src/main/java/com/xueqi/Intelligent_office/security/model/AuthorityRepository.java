package com.xueqi.Intelligent_office.security.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority,Integer> {
    Authority findFirstByName(AuthorityName name);
}
