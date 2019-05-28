package com.lxy.tmall.service;

import com.lxy.tmall.pojo.Category;
import com.lxy.tmall.util.Page;

import java.util.List;

/**
 * @ProjectName: tmall_ssm
 * @Package: com.lxy.tmall.service
 * @ClassName: CategoryService
 * @Author: XinyuLiu
 * @Date: 2019/5/23 17:33
 */
public interface CategoryService{
    List<Category> list();

    void add(Category category);

    void delete(int id);

    Category get(int id);

    void update(Category category);
}
