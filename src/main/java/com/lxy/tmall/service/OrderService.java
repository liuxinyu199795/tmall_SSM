package com.lxy.tmall.service;

import com.lxy.tmall.pojo.Order;
import com.lxy.tmall.pojo.OrderItem;

import java.util.List;

/**
 * @ProjectName: tmall_ssm
 * @Package: com.lxy.tmall.service
 * @ClassName: OrderService
 * @Author: XinyuLiu
 * @Date: 2019/5/27 18:01
 */
public interface OrderService {

    String waitPay = "waitPay";
    String waitDelivery = "waitDelivery";
    String waitConfirm = "waitConfirm";
    String waitReview = "waitReview";
    String finish = "finish";
    String delete = "delete";

    void add(Order c);
    float add(Order c,List<OrderItem> ois);
    void delete(int id);
    void update(Order c);
    Order get(int id);
    List list();
    List list(int uid, String excludedStatus);
}