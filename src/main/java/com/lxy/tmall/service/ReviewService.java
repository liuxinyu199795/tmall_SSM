package com.lxy.tmall.service;

import com.lxy.tmall.pojo.Review;

import java.util.List;

/**
 * @ProjectName: tmall_ssm
 * @Package: com.lxy.tmall.service
 * @ClassName: ReviewService
 * @Author: XinyuLiu
 * @Date: 2019/5/27 22:41
 */
public interface ReviewService {

    void add(Review c);

    void delete(int id);
    void update(Review c);
    Review get(int id);
    List list(int pid);

    int getCount(int pid);
}
