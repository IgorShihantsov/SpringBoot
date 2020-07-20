package com.shihantsov.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StorageService {
    List<String> items = new ArrayList<>();

    public void add(String item) {
        items.add(item);
    }

    public List<String> getAll() {
        return items;
    }
}
