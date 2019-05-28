package com.lxy.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxy.tmall.pojo.Order;
import com.lxy.tmall.service.OrderItemService;
import com.lxy.tmall.service.OrderService;
import com.lxy.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: tmall_ssm
 * @Package: com.lxy.tmall.controller
 * @ClassName: OrderController
 * @Author: XinyuLiu
 * @Date: 2019/5/27 18:13
 */
@Controller
@RequestMapping("")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;

    @RequestMapping("admin_order_list")
    public String list(Model model, Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());

        List<Order> os= orderService.list();

        int total = (int) new PageInfo<>(os).getTotal();
        page.setTotal(total);

        orderItemService.fill(os);

        model.addAttribute("os", os);
        model.addAttribute("page", page);

        return "admin/listOrder";
    }

    @RequestMapping("admin_order_delivery")
    public String delivery(Order o) throws IOException {
        o.setDeliveryDate(new Date());
        o.setStatus(OrderService.waitConfirm);
        orderService.update(o);
        return "redirect:admin_order_list";
    }
}
