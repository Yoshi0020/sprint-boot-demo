package com.example.demo.app.controller;

import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {

    // @Value("${server.error.path:${error.path:/error}}")
    private final String errorPath = "error";

    @Override
    public String getErrorPath() {
        return errorPath;
    }

    @RequestMapping("error")
    public String HandleError(final HttpServletRequest request, final Model model) {
        final Object statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (statusCode != null && statusCode.toString().equals("404")) {
            status = HttpStatus.NOT_FOUND;
        }

        model.addAttribute("timestamp", new Date());
        model.addAttribute("status", status.value());

        return errorPath;
    }

    // 動作確認用メソッド
    @RequestMapping("err")
    public String ErrorTest() {
        throw new IllegalAccessError("テスト用のエラーです。");
    }

}