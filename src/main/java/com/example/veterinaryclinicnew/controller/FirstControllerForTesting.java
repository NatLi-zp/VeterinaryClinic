package com.example.veterinaryclinicnew.controller;

import com.example.veterinaryclinicnew.entity.Client;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class FirstControllerForTesting {

    @GetMapping("/getTestController")
    public String getStr(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("getHeader : " + request.getHeader("User-Agent"));
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("SESSIONID".equals(cookie.getName())) {
                System.out.println("SESSIONID : " + cookie.getValue());
            }
            System.out.println("cookie : " + cookie.getName());
        }
        System.out.println("Status : " + response.getStatus());
        return "HELLO";
    }

}
