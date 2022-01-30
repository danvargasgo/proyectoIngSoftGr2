package com.unal.cronus.controller.login;

import com.unal.cronus.model.dto.GrupoDto;
import com.unal.cronus.model.entitity.*;
import com.unal.cronus.model.repository.GrupoNicheRespository;
import com.unal.cronus.model.service.ScheduleHasGrupoService;
import com.unal.cronus.model.service.StudentHasSubjectService;
import com.unal.cronus.model.service.StudentService;
import com.unal.cronus.model.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    @Autowired
    private ScheduleHasGrupoService scheduleHasGrupoService;

    @Autowired
    private GrupoNicheRespository grupoNicheRespository;

    @GetMapping()
    public String showStudentMainPage(Model model, Authentication auth){
        model.addAttribute("selectedsubjects", studentHasSubjectService.searchByEmail(auth.getName()));
        return "student";
    }

    @PostMapping()
    public String searchSubjects(@RequestParam("keyword") String keyword,@RequestParam("code") String code, Model model, Authentication auth){
        model.addAttribute("selectedsubjects", studentHasSubjectService.searchByEmail(auth.getName()));
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

    @GetMapping("/schedule")
    @ResponseBody
    public List<GrupoDto> getSchedule(Authentication auth) {
        Student student = studentService.searchById(auth.getName());
        List<ScheduleHasGrupo> scheduleHasGrupos = student.getSchedule().getScheduleHasGrupo();
        List<GrupoDto> gruposMapped = new ArrayList<>();

        for (int i = 0; i < scheduleHasGrupos.size(); i++) {
            Grupo grupo = scheduleHasGrupos.get(i).getGrupo();
            GrupoDto grupoDto = new GrupoDto();
            grupoDto.setNumber(grupo.getNumber());
            grupoDto.setClassroom(grupo.getClassroom());
            grupoDto.setHours(grupo.getHours());
            grupoDto.setTeacherName(grupo.getTeacher().getName());
            grupoDto.setTeacherLastName(grupo.getTeacher().getLastName());
            grupoDto.setSubjectCode(grupo.getSubject().getCode());
            grupoDto.setSubjectName(grupo.getSubject().getName());

            gruposMapped.add(grupoDto);
        }

        return gruposMapped;
    }

    @PostMapping("/schedule")
    @ResponseBody
    public String saveSchedule(@RequestBody GrupoDto grupoDto, Authentication auth) {
        Schedule schedule = studentService.searchById(auth.getName()).getSchedule();
        Grupo grupo = grupoNicheRespository.searchGrupoByNumberAndSubjectCode(grupoDto.getNumber(),grupoDto.getSubjectCode());
        if (scheduleHasGrupoService.scheduleHasSubject(new ScheduleHasGrupo(schedule, grupo))){
            // Ya existe un grupo de esa materia en el horario
            return "FAIL";
        }else{
            scheduleHasGrupoService.saveScheduleHasGrupo(new ScheduleHasGrupo(schedule, grupo));
            return "OK";
        }

    }

    @DeleteMapping("/schedule")
    @ResponseBody
    public void deleteSchedule(@RequestBody GrupoDto grupoDto, Authentication auth){
        Schedule schedule = studentService.searchById(auth.getName()).getSchedule();
        Grupo grupo = grupoNicheRespository.searchGrupoByNumberAndSubjectCode(grupoDto.getNumber(),grupoDto.getSubjectCode());
        scheduleHasGrupoService.deleteScheduleHasGrupo(new ScheduleHasGrupo(schedule, grupo));
    }


}
