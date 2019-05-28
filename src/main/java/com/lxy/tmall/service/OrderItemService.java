package com.lxy.tmall.service;

import com.lxy.tmall.pojo.Order;
import com.lxy.tmall.pojo.OrderItem;

import java.util.List;

/**
 * @ProjectName: tmall_ssm
 * @Package: com.lxy.tmall.service
 * @ClassName: OrderItemServiceImpl
 * @Author: XinyuLiu
 * @Date: 2019/5/27 17:59
 */
public interface OrderItemService {

    void add(OrderItem c);

    void delete(int id);
    void update(OrderItem c);
    OrderItem get(int id);
    List list();

    void fill(List<Order> os);

    void fill(Order o);

    int getSaleCount(int  pid);

    List<OrderItem> listByUser(int uid);
}
