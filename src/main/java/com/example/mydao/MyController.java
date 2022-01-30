package com.example.mydao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    @GetMapping("/products/fetch-product")
    public String name(@RequestParam(required = false) String name) {
        System.out.println("hi " + name);
        return "fetch-product";
    }
}