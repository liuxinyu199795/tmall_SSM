package com.lxy.tmall.service;

import com.lxy.tmall.pojo.Category;
import com.lxy.tmall.pojo.Product;

import java.util.List;

/**
 * @ProjectName: tmall_ssm
 * @Package: com.lxy.tmall.service
 * @ClassName: ProductService
 * @Author: XinyuLiu
 * @Date: 2019/5/27 14:39
 */
public interface ProductService {
    void add(Product p);
    void delete(int id);
    void update(Product p);
    Product get(int id);
    List list(int cid);
    void setFirstProductImage(Product p);

    void fill(List<Category> cs);

    void fill(Category c);

    void fillByRow(List<Category> cs);

    void setSaleAndReviewNumber(Product p);

    void setSaleAndReviewNumber(List<Product> ps);

    List<Product> search(String keyword);
}
