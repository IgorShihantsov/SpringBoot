package com.shihantsov.service;

import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RandomService {
    public String generateRandomString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;

    }

    public List<Integer> generateRandomInts() {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            integerList.add((int) (Math.random() * 100));
        return integerList;
    }
}

