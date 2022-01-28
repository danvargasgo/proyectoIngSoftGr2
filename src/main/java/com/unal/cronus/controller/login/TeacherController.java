package com.unal.cronus.controller.login;

import com.unal.cronus.model.entitity.Student;
import com.unal.cronus.model.entitity.StudentHasSubject;
import com.unal.cronus.model.entitity.Subject;
import com.unal.cronus.model.entitity.Teacher;
import com.unal.cronus.model.repository.GrupoRepository;
import com.unal.cronus.model.service.GrupoService;
import com.unal.cronus.model.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private/teacher")
public class TeacherController {
    @Autowired
    private GrupoService grupoService;

    @Autowired
    private SubjectService subjectService;

    @GetMapping()
    public String showTeacherMainPage(Model model, Authentication auth){
        model.addAttribute("subjects", subjectService.searchSubjectsByGrupos(grupoService.
                searchGruposTeacher(auth.getName())));
        return "teacher";
    }
}
