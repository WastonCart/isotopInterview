package com.example.demo.config;

import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

@Configuration
public class OkHttpConfig {

    @Value("${proxy.host}")
    private String proxyHost;
    @Value("${proxy.port}")
    private int port;

    @Bean
    public OkHttpClient buildHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (proxyHost != null && port != 0) {
            builder.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, port)));
        }
        return builder/*.readTimeout(30, TimeUnit.SECONDS)*/
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
    }
}
