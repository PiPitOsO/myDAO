package com.example.mydao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping()
public class MyController {
    @GetMapping()
    public String name() {
        return "gi";
    }

    @GetMapping("/products/fetch-product")
    public String name(@RequestParam("name") String name) {
        System.out.println("hi " + name);
        return "fetch-product";
    }
}