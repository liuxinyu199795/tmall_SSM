package com.lxy.tmall.service.impl;

import com.lxy.tmall.mapper.CategoryMapper;
import com.lxy.tmall.pojo.Category;
import com.lxy.tmall.pojo.CategoryExample;
import com.lxy.tmall.service.CategoryService;
import com.lxy.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: tmall_ssm
 * @Package: com.lxy.tmall.service.impl
 * @ClassName: CategoryServiceImpl
 * @Author: XinyuLiu
 * @Date: 2019/5/23 17:32
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> list() {
        CategoryExample example =new CategoryExample();
        example.setOrderByClause("id desc");
        return categoryMapper.selectByExample(example);
    }

    @Override
    public void add(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public void delete(int id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Category get(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }
}
