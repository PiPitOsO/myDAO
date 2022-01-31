package com.example.mydao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/products/fetch-product")
public class MyController {
    @Autowired
    private MyService service;

    public MyController(MyService service) {
        this.service = service;
    }

    @GetMapping
    public String name(@RequestParam(required = false) String name) {
        if (name != null) {
            service.getProductName(name);
        }
        return "fetch-product";
    }

//    @GetMapping
//    public String quest() {
//        return service.getProductName("Vova");
//    }
}