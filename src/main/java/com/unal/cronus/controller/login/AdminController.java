package com.unal.cronus.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private/admin")
public class AdminController {

    @GetMapping()
    public String showAdminMainPage(){
        return "admin";
    }
}
