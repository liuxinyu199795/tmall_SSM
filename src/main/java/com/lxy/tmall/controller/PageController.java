package com.lxy.tmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: tmall_ssm
 * @Package: com.lxy.tmall.controller
 * @ClassName: PageController
 * @Author: XinyuLiu
 * @Date: 2019/5/27 22:18
 */
@Controller
@RequestMapping("")
public class PageController {
    @RequestMapping("registerPage")
    public String registerPage() {
        return "fore/register";
    }
    @RequestMapping("registerSuccessPage")
    public String registerSuccessPage() {
        return "fore/registerSuccess";
    }
    @RequestMapping("loginPage")
    public String loginPage() {
        return "fore/login";
    }
    @RequestMapping("forealipay")
    public String alipay(){
        return "fore/alipay";
    }
}
