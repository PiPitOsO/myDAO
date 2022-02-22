package com.example.mydao.controller;

import com.example.mydao.service.MyService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/products/fetch-product")
public class MyController {
    private final MyService service;

    public MyController(MyService service) {
        this.service = service;
    }

    @GetMapping
    public void name(@RequestParam(required = false) String name, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        final var data = service.getProductName(name);
        final var gson = new Gson();
        response.getWriter().print(gson.toJson(data));
    }
}