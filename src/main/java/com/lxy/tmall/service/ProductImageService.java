package com.lxy.tmall.service;

import com.lxy.tmall.pojo.ProductImage;

import java.util.List;

/**
 * @ProjectName: tmall_ssm
 * @Package: com.lxy.tmall.service
 * @ClassName: ProductImageService
 * @Author: XinyuLiu
 * @Date: 2019/5/27 15:36
 */
public interface ProductImageService {

    String type_single = "type_single";
    String type_detail = "type_detail";

    void add(ProductImage pi);
    void delete(int id);
    void update(ProductImage pi);
    ProductImage get(int id);
    List list(int pid, String type);
}
