package com.xueqi.Intelligent_office.service.serviceinfo;

public interface FDService {
    Object delete(int id);
    Object findAll();
    Object findOne(int id);
    boolean isPresent(int id);
    Object save(Object o);
}
