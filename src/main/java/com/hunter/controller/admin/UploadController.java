package com.hunter.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by lixiang on 2018/3/17.
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

        @RequestMapping("/xx")
        public Object uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
                File file1 = new File("D:\\"+file.getOriginalFilename());
                file.transferTo(file1);
                return "";
        }

        @RequestMapping("/ss")
        public Object uploadImages(@RequestParam("file") MultipartFile[] files) throws IOException {
                for(MultipartFile file:files){
                        File file1 = new File("D:\\"+file.getOriginalFilename());
                        file.transferTo(file1);
                }
                return "";
        }
}
