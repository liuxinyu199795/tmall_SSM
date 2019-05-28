package com.lxy.tmall.util;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ProjectName: tmall_ssm
 * @Package: com.lxy.tmall.util
 * @ClassName: UploadedImageFile
 * @Author: XinyuLiu
 * @Date: 2019/5/26 20:16
 */
public class UploadedImageFile {
    MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
