package com.lg.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lin
 * @ClassName HttpController
 * @date 2018/9/3 13:05
 * @description
 **/

@Controller
public class HttpController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
}
