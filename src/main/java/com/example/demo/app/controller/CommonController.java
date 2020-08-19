package com.example.demo.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    @RequestMapping(value={"/", "/manage"})
    public String index() {
        return "redirect:/manage/home";
    }

    @RequestMapping("/manage/home")
    public String indexManage(){
        return "/manage/home";
    }
}