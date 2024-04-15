package org.fwx.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @ClassName FileUpAndDownloadController
 * @Description 文件上传下载
 * @Author Fwx
 * @Date 2024/4/15 10:00
 * @Version 1.0
 */
@Controller
public class FileUpAndDownloadController {

    /**
     * 文件下载
     * @param session
     * @return
     */
    @RequestMapping("/download")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/img/1.jpg");
        //创建输入流
        InputStream is = null;
        ResponseEntity<byte[]> responseEntity = null;
        try {
            is = new FileInputStream(realPath);
            //创建字节数组
            byte[] bytes = new byte[is.available()];
            //将流读到字节数组中
            is.read(bytes);
            //创建HttpHeaders对象设置响应头信息
            MultiValueMap<String, String> headers = new HttpHeaders();
            //设置要下载方式以及下载文件的名字
            headers.add("Content-Disposition", "attachment;filename=1.jpg");
            //设置响应状态码
            HttpStatus statusCode = HttpStatus.OK;
            //创建ResponseEntity对象
            responseEntity = new ResponseEntity<>(bytes, headers,
                    statusCode);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭输入流
            try {
                if (is!=null) {is.close();}
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return responseEntity;
    }

    @RequestMapping("/upload")
    public String testUp(MultipartFile photo, HttpSession session) throws
            IOException {
        //获取上传的文件的文件名
        String fileName = photo.getOriginalFilename();
        //处理文件重名问题
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + hzName;
        //获取服务器中photo目录的路径
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        File file = new File(photoPath);
        if(!file.exists()){
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + fileName;
        //实现上传功能
        photo.transferTo(new File(finalPath));
        return "success";
    }
}
