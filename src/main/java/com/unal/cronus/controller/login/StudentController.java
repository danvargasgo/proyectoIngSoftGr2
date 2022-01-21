package com.unal.cronus.controller.login;

import com.unal.cronus.model.entitity.Student;
import com.unal.cronus.model.entitity.StudentHasSubject;
import com.unal.cronus.model.entitity.Subject;
import com.unal.cronus.model.service.StudentHasSubjectService;
import com.unal.cronus.model.service.StudentService;
import com.unal.cronus.model.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/private/student")
public class StudentController{

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentHasSubjectService studentHasSubjectService;

    @GetMapping()
    public String showStudentMainPage(){
        return "student";
    }

    @PostMapping()
    public String searchSubjects(@RequestParam("keyword") String keyword,@RequestParam("code") String code, Model model){
        if ((code=="")&&(keyword=="")){
            model.addAttribute("subjects", new ArrayList<Subject>());
        }
        else if (code!="") {
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

    @GetMapping("/addsubject/{student_email}/{subject_code}")
    public String addSubjectToStudent(@PathVariable("student_email") String student_email, @PathVariable("subject_code") int subject_code, Model model){

        Student student = studentService.searchById(student_email);
        Subject subject = subjectService.searchSubjectsByCode(subject_code);
        StudentHasSubject studentHasSubject= new StudentHasSubject(student,subject);
        studentHasSubjectService.saveStudentHasSubject(studentHasSubject);


        return "redirect:/private/student";
    }
}
