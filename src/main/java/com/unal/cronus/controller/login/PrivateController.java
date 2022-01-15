package com.unal.cronus.controller.login;

import com.unal.cronus.model.entitity.User;
import com.unal.cronus.model.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/private")
public class PrivateController {

    protected UserService userService;

    public PrivateController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public String index(Authentication auth, HttpSession session){

        String email = auth.getName();
        Optional<User> oUser= userService.findById(email);
        User user = oUser.get();
        String type = user.getTypeUser().toString();
        if(type.equals("STUDENT")){
            return "redirect:/private/student";
        }
        else if (type.equals("ADMIN")){
            return "admin";
        }
        return "index";
    }
}
