package com.lxy.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxy.tmall.pojo.Category;
import com.lxy.tmall.service.CategoryService;
import com.lxy.tmall.util.ImageUtil;
import com.lxy.tmall.util.Page;
import com.lxy.tmall.util.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @ProjectName: tmall_ssm
 * @Package: com.lxy.tmall.controller
 * @ClassName: CategoryController
 * @Author: XinyuLiu
 * @Date: 2019/5/23 17:47
 */
@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    //查询
    @RequestMapping("admin_category_list")
    public String list(Model model,Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Category> cs= categoryService.list();
        int total = (int) new PageInfo<>(cs).getTotal();
        page.setTotal(total);
        model.addAttribute("cs", cs);
        model.addAttribute("page", page);
        return "admin/listCategory";
    }

    //增加
    @RequestMapping("admin_category_add")
    public String add(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        System.out.println(c.getId());
        categoryService.add(c);
        System.out.println(c.getId());
        File imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,c.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        System.out.println(uploadedImageFile);
        System.out.println(uploadedImageFile.getImage());
        System.out.println(file);
        uploadedImageFile.getImage().transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);

        return "redirect:/admin_category_list";
    }

    //删除
    @RequestMapping("admin_category_delete")
    public String delete(int id,HttpSession session) throws IOException {
        categoryService.delete(id);

        File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();

        return "redirect:/admin_category_list";
    }

    //编辑
    @RequestMapping("admin_category_edit")
    public String edit(int id,Model model) throws IOException {
        Category c= categoryService.get(id);
        model.addAttribute("c", c);
        return "admin/editCategory";
    }

    //更改
    @RequestMapping("admin_category_update")
    public String update(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        categoryService.update(c);
        MultipartFile image = uploadedImageFile.getImage();
        if(null!=image &&!image.isEmpty()){
            File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
            File file = new File(imageFolder,c.getId()+".jpg");
            image.transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);
        }
        return "redirect:/admin_category_list";
    }
}
