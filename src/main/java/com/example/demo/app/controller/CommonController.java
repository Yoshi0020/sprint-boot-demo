package com.example.demo.app.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
    
    @RequestMapping("/")
    public String index()
    {
        return "redirect:/item";
    }
}