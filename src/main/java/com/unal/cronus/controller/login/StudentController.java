package com.unal.cronus.controller.login;

import com.unal.cronus.model.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/private/student")
public class StudentController{

    @Autowired
    private SubjectService subjectService;

    @GetMapping()
    public String showStudentMainPage(){
        return "student";
    }

    @PostMapping()
    public String searchSubjects(@RequestParam("keyword") String keyword,@RequestParam("code") String code, Model model){
        if (code!="") {
            model.addAttribute("subjects", subjectService.searchSubjectsByCode(Integer.parseInt(code)));
        } else {
            model.addAttribute("subjects",subjectService.searchSubjectsByName(keyword));
        }
        return "student";
    }

    @GetMapping("/subject/{code}")
    public String showSubjectPage(@PathVariable("code") int code, Model model){
        model.addAttribute("subject",subjectService.searchSubjectsByCode(code));
        return "subject";
    }
}
