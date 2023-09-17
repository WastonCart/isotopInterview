package com.example.demo.service.impl;

import com.example.demo.cache.Cache;
import com.example.demo.pojo.Nft;
import com.example.demo.pojo.OpenseaResponse;
import com.example.demo.service.ImgService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service(value = "imgService")
@Slf4j
public class ImgServiceImpl implements ImgService {
    @Autowired
    private OkHttpClient client;
    @Value("${opensea.url}")
    private String requestUrl;

    
    private final String IMG_KEY = "CHAIN_IMG";

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    void init() {

    }

    @Override
    public String getImg() throws IOException {

        return (String) Cache.get(IMG_KEY);

    }

    @Scheduled(cron = "0 0/1 * * * ?")
    private void fetch() {
        try {
            Nft nft = getRequest();
            if (nft != null) {
                String value = nft.getMetadataUrl();
                value = value.split(",")[1];
                log.info("write to cache : {}", value);
                Cache.put(IMG_KEY, value);
                log.info("finished write cache");

            }
        }catch (IOException e) {
            log.error("网络请求失败");
        }
    }

    private Nft getRequest() throws IOException {
        Request request = new Request.Builder()
                .url(requestUrl)
                .addHeader("accept", "application/json")
                .get()
                .build();

        try(Response response = client.newCall(request).execute()) {
            if (response.code() == 200) {
                InputStream inputStream = response.body().byteStream();
                OpenseaResponse openseaResponse = objectMapper.readValue(inputStream, OpenseaResponse.class);
                Nft nft = openseaResponse.getNft();
                return nft;
            }
        }
        return null;
    }

}
