package com.example.demo.cache;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    private static ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>(1);

    public static void put(String key, Object value) {
        map.put(key, value);
    }

    public static void delete(String key) {
        map.remove(key);
    }

    public static Object get(String key) {
        return map.get(key);
    }
}
