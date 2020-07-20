package com.shihantsov.controller;

import com.shihantsov.service.RandomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    RandomService randomService;

    public IndexController(RandomService randomService) {
        this.randomService = randomService;
    }

    @GetMapping("/random2")
    public String random(Model model) {
        List<Integer> integerList = randomService.generateRandomInts();
        model.addAttribute("ints", integerList);
        return "random2";
    }

    @GetMapping("/random")
    @ResponseBody
    public String random() {
        return randomService.generateRandomString();
    }

    ////////////////////////////
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String indexPost(@RequestParam String login,
                            @RequestParam String password) {
        if (login.equals("root") && password.equals("root"))
            return "greeting";
        else return "index";
    }


    @GetMapping("/name")
    //@ResponseBody
    public String name(@RequestParam String name,
                       @RequestParam String city,
                       Model model) {
        model.addAttribute("name", name);
        model.addAttribute("city", "Minsk");
        List<String> products = new ArrayList<>();
        products.add("AAA");
        model.addAttribute("products", products);
        return "greeting";
    }

    @GetMapping("/secret")
    @ResponseBody
    public String secret() {
        return "secret";
    }

    //http://localhost:8080/secret
    //http://localhost:8080
    //http://localhost:8080/sum?a=5&b=5
    @GetMapping("/sum")
    @ResponseBody
    public String sum(@RequestParam() Integer a,
                      @RequestParam() Integer b,
                      @RequestParam(required = false, defaultValue = "99") Integer c) {
        return String.valueOf(a + b + c);
    }

    @GetMapping("/calc")
    @ResponseBody
    public String calc(@RequestParam() Integer a,
                       @RequestParam() Integer b,
                       @RequestParam(required = false, defaultValue = "+") String operation) {
        switch (operation) {

            case "-":
                return String.valueOf(a - b);
            case "*":
                return String.valueOf(a * b);
            case "/":
                return String.valueOf(a / b);
            case "+":
            default:
                return String.valueOf(a + b);
        }

    }
}
