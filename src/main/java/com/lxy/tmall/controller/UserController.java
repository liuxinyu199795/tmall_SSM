package com.lxy.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxy.tmall.pojo.User;
import com.lxy.tmall.service.UserService;
import com.lxy.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ProjectName: tmall_ssm
 * @Package: com.lxy.tmall.controller
 * @ClassName: UserController
 * @Author: XinyuLiu
 * @Date: 2019/5/27 17:39
 */
@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("admin_user_list")
    public String list(Model model, Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());

        List<User> us= userService.list();

        int total = (int) new PageInfo<>(us).getTotal();
        page.setTotal(total);

        model.addAttribute("us", us);
        model.addAttribute("page", page);

        return "admin/listUser";
    }

}
