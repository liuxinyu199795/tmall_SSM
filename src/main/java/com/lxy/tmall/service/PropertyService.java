package com.lxy.tmall.service;

import com.lxy.tmall.pojo.Property;

import java.util.List;

/**
 * @ProjectName: tmall_ssm
 * @Package: com.lxy.tmall.service
 * @ClassName: PropertyService
 * @Author: XinyuLiu
 * @Date: 2019/5/27 13:45
 */
public interface PropertyService {
    void add(Property c);
    void delete(int id);
    void update(Property c);
    Property get(int id);
    List list(int cid);
}
