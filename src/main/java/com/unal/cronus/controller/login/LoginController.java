package com.unal.cronus.controller.login;

import com.unal.cronus.model.dto.StudentDto;
import com.unal.cronus.model.entitity.Schedule;
import com.unal.cronus.model.entitity.Student;
import com.unal.cronus.model.entitity.Teacher;
import com.unal.cronus.model.enums.TypeUser;
import com.unal.cronus.model.mapper.StudentMapper;
import com.unal.cronus.model.service.UserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "true")
public class LoginController {

    protected UserService userService;
    protected StudentMapper studentMapper;

    public LoginController (UserService userService , StudentMapper studentMapper){
        this.studentMapper=studentMapper;
        this.userService = userService;
    }


    @GetMapping("/signup")
    public String registroForm(Model model){
        model.addAttribute("studentDto",new StudentDto());
        return "signup";
    }/*

    @GetMapping("/signup")
    public String registroForm(Model model){
        model.addAttribute("studentDto",new Teacher());
        return "signup";
    }*/

    @PostMapping("/signup")
    public String registro(@Valid StudentDto studentDto, BindingResult result,Model model){

        if(result.hasErrors()){
            return "/signup";
        }
        else{

            Student usuario = studentMapper.mapStudent(studentDto);
            usuario.setSchedule(new Schedule());
            usuario.setTypeUser(TypeUser.STUDENT);
            model.addAttribute("user",userService.save(usuario));
            return "redirect:/login";
        }
    }

    /*
        @PostMapping("/signup")
        public String registro(Teacher teacher, Model model){
            Teacher teacher2= teacher;

                teacher2.setTypeUser(TypeUser.TEACHER);
                model.addAttribute("user",userService.save(teacher2));
                return "redirect:/login";

        }*/
    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("user",new StudentDto());

        return "login";
    }

}
