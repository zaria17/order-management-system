package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

public class imageController {
    @ResponseBody
    @RequestMapping(value = "/api/uploadImage", method = RequestMethod.POST)
    public String uploadImage(@RequestParam("files") MultipartFile file) throws IllegalStateException, IOException {
        System.out.println(file.getOriginalFilename() + "图片已传入!!");
        byte[] b = file.getBytes();
        String str = Base64.getEncoder().encodeToString(b);
        return "data:image/jpeg;base64," + str;
    }

}
