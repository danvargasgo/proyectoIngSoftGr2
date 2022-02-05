package com.unal.cronus.controller.login;

import com.unal.cronus.model.entitity.Subject;
import com.unal.cronus.model.service.ScheduleHasGrupoService;
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
@RequestMapping("/private/admin")
public class AdminController {

    @Autowired
    StudentHasSubjectService studentHasSubjectService;

    @Autowired
    StudentService studentService;

    @Autowired
    ScheduleHasGrupoService scheduleHasGrupoService;

    @Autowired
    SubjectService subjectService;

    @GetMapping()
    public String showAdminMainPage(Model model){
        double numberStudents = studentService.numberStudents();
        int sumCredits = scheduleHasGrupoService.sumCredits();
        int countSubjects = scheduleHasGrupoService.countSubjects();
        int hours = countSubjects * 4;

        model.addAttribute("promedios", new double[]{sumCredits / numberStudents, countSubjects / numberStudents, hours / numberStudents});
        model.addAttribute("top3Subjects", studentHasSubjectService.searchTop3Subjects());
        return "admin";
    }

    @PostMapping()
    public String searchSubjects(@RequestParam("keyword") String keyword, @RequestParam("code") String code, Model model, Authentication auth){
        double numberStudents = studentService.numberStudents();
        int sumCredits = scheduleHasGrupoService.sumCredits();
        int countSubjects = scheduleHasGrupoService.countSubjects();
        int hours = countSubjects * 4;

        model.addAttribute("promedios", new double[]{sumCredits / numberStudents, countSubjects / numberStudents, hours / numberStudents});
        model.addAttribute("top3Subjects", studentHasSubjectService.searchTop3Subjects());

        if ((code=="")&&(keyword=="")){
            model.addAttribute("subjects", new ArrayList<Subject>());
        }
        else if (code!="") {
            model.addAttribute("subjects", subjectService.searchSubjectsByCode(Integer.parseInt(code)));
        } else {
            model.addAttribute("subjects",subjectService.searchSubjectsByName(keyword));
        }
        return "admin";
    }

    @GetMapping("/subject/{code}")
    public String showSubjectPage(@PathVariable("code") int code, Model model){
        model.addAttribute("subject",subjectService.searchSubjectsByCode(code));
        model.addAttribute("cantidadSeleccionadas", studentHasSubjectService.countStudent(code));
        model.addAttribute("gruposSeleccionados", scheduleHasGrupoService.selectedGroups(code));
        return "subjectAdmin";
    }

    @PostMapping("/subject/{code}")
    public String searchSubjects(@PathVariable("code") int code, @RequestParam("keyword") String keyword, @RequestParam("code") String codeFormulario, Model model, Authentication auth){
        model.addAttribute("subject",subjectService.searchSubjectsByCode(code));
        model.addAttribute("cantidadSeleccionadas", studentHasSubjectService.countStudent(code));
        model.addAttribute("gruposSeleccionados", scheduleHasGrupoService.selectedGroups(code));

        if ((codeFormulario=="")&&(keyword=="")){
            model.addAttribute("subjects", new ArrayList<Subject>());
        }
        else if (codeFormulario!="") {
            model.addAttribute("subjects", subjectService.searchSubjectsByCode(Integer.parseInt(codeFormulario)));
        } else {
            model.addAttribute("subjects",subjectService.searchSubjectsByName(keyword));
        }

        return "subjectAdmin";
    }
}
