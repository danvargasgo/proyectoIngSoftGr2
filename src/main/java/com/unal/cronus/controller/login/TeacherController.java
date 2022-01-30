package com.unal.cronus.controller.login;

import com.unal.cronus.model.dto.GrupoDto;
import com.unal.cronus.model.entitity.Grupo;
import com.unal.cronus.model.entitity.Subject;
import com.unal.cronus.model.entitity.Teacher;
import com.unal.cronus.model.service.GrupoService;
import com.unal.cronus.model.service.SubjectService;
import com.unal.cronus.model.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/private/teacher")
public class TeacherController {
    @Autowired
    private GrupoService grupoService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private TeacherService teacherService;

    @GetMapping()
    public String showTeacherMainPage(Model model, Authentication auth){
        /*model.addAttribute("subjects", subjectService.searchSubjectsByGrupos(grupoService.
                searchGruposTeacher(auth.getName())));*/
        Optional<Teacher> oteacher = teacherService.findById(auth.getName());
        Teacher teacher = oteacher.get();
        List<Grupo> groups = teacher.getGrupos();
//        List<Subject> subjects=new ArrayList<>();

        model.addAttribute("groups",groups) ;

        /*for (Grupo group :
                groups) {
            Subject subject = group.getSubject();
            if (!subjects.contains(subject)){
                subjects.add(subject);
            }
        }*/
//        model.addAttribute("subjects",subjects);

        return "teacher";
    }

    /*@GetMapping("/{code}")
    public String showTeacherMainPage (@PathVariable("code") int code, Model model,Authentication auth){
        model.addAttribute("code",code);
        System.out.println(auth.getName());
        return "teacherGroup";

    }*/
    @GetMapping("/group/save")
    public String showFormGroup(Model model){
        model.addAttribute("grupoDto",new GrupoDto());
        return "formGroup";
    }
    @PostMapping("/group/save")
    public String saveGroup(@Valid GrupoDto grupoDto, BindingResult result,Authentication auth){

        if(result.hasErrors()){
            return "/formGroup";
        }
        else{
            Subject subject = subjectService.searchSubjectsByCode(grupoDto.getSubjectCode());
            Optional<Teacher> oteacher = teacherService.findById(auth.getName());
            Teacher teacher = oteacher.get();
            Grupo grupo = new Grupo(7,grupoDto.getClassroom(),grupoDto.getHours(),subject,teacher);
            grupoService.save(grupo);
            System.out.println("insercion realizada");
            return "redirect:/private/teacher";
        }
    }

    @GetMapping("/group/edit/{number}/{code}")
    public String showFormGroupEdit(@PathVariable int number, @PathVariable int code, Model model){
        GrupoDto grupoDto = new GrupoDto();
        Grupo grupo = grupoService.findByNumberAndSubject(number,subjectService.searchSubjectsByCode(code));
        grupoDto.setClassroom(grupo.getClassroom());
        grupoDto.setHours(grupo.getHours());
        grupoDto.setNumber(grupo.getNumber());
        grupoDto.setSubjectCode(grupo.getSubject().getCode());

        model.addAttribute("grupoDto",grupoDto);
        return "formGroupEdit";
    }

    @PostMapping("/group/edit")
    public String saveGroupEdit(@Valid GrupoDto grupoDto, BindingResult result,Authentication auth,@RequestParam(value = "number") int number,@RequestParam(value = "code") int code){

        if(result.hasErrors()){
            System.out.println("hola");
            return "/formGroupEdit";
        }
        else{
            System.out.println(number);
            System.out.println(code);
            Subject subject = subjectService.searchSubjectsByCode(code);
            Optional<Teacher> oteacher = teacherService.findById(auth.getName());
            Teacher teacher = oteacher.get();
            Grupo grupo = new Grupo(number,grupoDto.getClassroom(),grupoDto.getHours(),subject,teacher);
            grupoService.save(grupo);
            System.out.println("actualizacion realizada");
            return "redirect:/private/teacher";
        }
    }

    @GetMapping("/group/delete/{grupoNumber}/{grupoSubject}")
    public String deleteGroup(@PathVariable int grupoNumber, @PathVariable int grupoSubject){
        grupoService.delete(grupoService.findByNumberAndSubject(grupoNumber, subjectService.searchSubjectsByCode(grupoSubject)));

        return "redirect:/private/teacher";
    }
}
