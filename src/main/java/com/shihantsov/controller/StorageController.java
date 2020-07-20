package com.shihantsov.controller;

import com.shihantsov.service.StorageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StorageController {
    StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;

    }


    @GetMapping("/storage/add")
    @ResponseBody
    public void addValue(String value) {
        storageService.add(value);
    }

    @GetMapping("/storage/getAll")
    @ResponseBody
    public List<String> getAll(){
        return storageService.getAll();
    }
}
