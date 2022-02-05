package com.unal.cronus.controller.login;

import com.unal.cronus.model.service.StudentHasSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/private/admin")
public class AdminController {

    @Autowired
    StudentHasSubjectService studentHasSubjectService;

    @GetMapping()
    public String showAdminMainPage(Model model){
        model.addAttribute("top3Subjects", studentHasSubjectService.searchTop3Subjects());

        return "admin";
    }
}
