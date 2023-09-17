package com.example.demo.controller;

import com.example.demo.exception.ServerException;
import com.example.demo.pojo.Nft;
import com.example.demo.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/img")
public class ImgController {
    @Autowired
    ImgService imgService;
    @GetMapping
    public String getImg() {
        try {
            return imgService.getImg();
        } catch (IOException e) {
            throw new ServerException(e);
        }
    }
}
