package com.example.thymeleaftest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
    @GetMapping
    public String index(){

        return "index";
    }
}
