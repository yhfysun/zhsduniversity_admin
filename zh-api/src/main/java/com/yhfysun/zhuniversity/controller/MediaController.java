package com.yhfysun.zhuniversity.controller;

import com.yhfysun.zhuniversity.common.core.controller.BaseController;
import com.yhfysun.zhuniversity.common.core.domain.AjaxResult;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

/** 
 * 媒体资源
 * @author yaoyang_han
 * @createTime 2024/7/21 上午 10:06
 **/
@RestController
@RequestMapping("/app/media")
public class MediaController extends BaseController {
    
    private static final int BUFFER_SIZE = 4096;
 
    // 假设图片存储在项目的static/images目录下
    private static final String IMAGE_FOLDER = "E:\\project\\HBuilderProjects\\zhsdUniversity\\zhsdUniversity\\static\\jpg\\";
 
    // 假设视频存储在项目的static/videos目录下
    private static final String VIDEO_FOLDER = "E:\\project\\HBuilderProjects\\zhsdUniversity\\zhsdUniversity\\static\\video\\nuanshan\\";
    
    private static final String VIDEO_FOLDER_MP4 = "E:\\project\\HBuilderProjects\\zhsdUniversity\\zhsdUniversity\\static\\video\\";
 
    @GetMapping("/image/{filename:.+}")
    public void getImage(@PathVariable String filename, HttpServletResponse response) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(IMAGE_FOLDER + filename);
        copyToResponse(fileInputStream, response, "image/jpeg");
    }
 
    @GetMapping("/video/{filename:.+}")
    public void getVideo(@PathVariable String filename, HttpServletResponse response) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(VIDEO_FOLDER_MP4 + filename);
        copyToResponse(fileInputStream, response, "image/mp4");
    }
    
    @GetMapping("/stream/{filename}")
    public ResponseEntity<Resource> getM3U8Video(@PathVariable String filename, HttpServletResponse response) throws MalformedURLException {
        Path m3u8VideoDirectory = Paths.get(VIDEO_FOLDER);
        Path m3u8FilePath = m3u8VideoDirectory.resolve(filename);
        Resource resource = new UrlResource(m3u8FilePath.toUri());
    
        if (resource.exists() || resource.isReadable()) {
            return ResponseEntity.ok()
                           .contentType(MediaType.APPLICATION_OCTET_STREAM)
                           .body(resource);
        } else {
            // 文件未找到，可以返回404或其他错误状态
            return ResponseEntity.notFound().build();
        }
    }
    
    private void copyToResponse(InputStream inputStream, HttpServletResponse response, String contentType) throws IOException {
        response.setContentType(contentType);
        response.setHeader("Content-Disposition", "attachment");
 
        try (OutputStream outputStream = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } finally {
            inputStream.close();
        }
    }
}