package com.unal.cronus.controller.login;

import com.unal.cronus.model.dto.StudentDto;
import com.unal.cronus.model.entitity.Schedule;
import com.unal.cronus.model.entitity.Student;
import com.unal.cronus.model.enums.TypeUser;
import com.unal.cronus.model.mapper.StudentMapper;
import com.unal.cronus.model.service.UserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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
        model.addAttribute("studentdto",new StudentDto());
        return "signup";
    }
    @PostMapping("/signup")
    public String registro(@Valid @ModelAttribute StudentDto studentDto, BindingResult result,Model model){
        if(result.hasErrors()){
            return "redirect:/signup";
        }
        else{

            Student usuario = studentMapper.mapStudent(studentDto);
            usuario.setSchedule(new Schedule(5));
            usuario.setTypeUser(TypeUser.STUDENT);
            model.addAttribute("user",userService.save(usuario));
            return "redirect:/login";
        }
    }
    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("user",new StudentDto());

        return "login";
    }

}
