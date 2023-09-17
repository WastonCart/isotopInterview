package com.example.demo.service.impl;

import com.example.demo.pojo.Nft;
import com.example.demo.service.ImgService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ImgServiceImplTest {
    @Autowired
    ImgService imgService;

    @Test
    void getImg() throws IOException {
        String img = imgService.getImg();
        assertNotNull(img);
        System.out.println(img);
    }

}