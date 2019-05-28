package com.lxy.tmall.service;

import com.lxy.tmall.pojo.Product;
import com.lxy.tmall.pojo.PropertyValue;

import java.util.List;

/**
 * @ProjectName: tmall_ssm
 * @Package: com.lxy.tmall.service
 * @ClassName: PropertyValueService
 * @Author: XinyuLiu
 * @Date: 2019/5/27 17:00
 */
public interface PropertyValueService {
    void init(Product p);
    void update(PropertyValue pv);

    PropertyValue get(int ptid, int pid);
    List<PropertyValue> list(int pid);
}
