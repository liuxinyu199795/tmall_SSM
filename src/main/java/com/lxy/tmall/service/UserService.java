package com.lxy.tmall.service;

import com.lxy.tmall.pojo.User;

import java.util.List;

/**
 * @ProjectName: tmall_ssm
 * @Package: com.lxy.tmall.service
 * @ClassName: UserService
 * @Author: XinyuLiu
 * @Date: 2019/5/27 17:33
 */
public interface UserService {
    void add(User c);
    void delete(int id);
    void update(User c);
    User get(int id);
    List list();
    boolean isExist(String name);

    User get(String name, String password);
}
