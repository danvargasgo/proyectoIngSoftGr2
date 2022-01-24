package com.unal.cronus.controller.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unal.cronus.model.dto.StudentDto;
import com.unal.cronus.model.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
class LoginControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;




    @Test
    void validandoForm() throws Exception {
        UserDto user = new StudentDto("danielbonilla@gmail.com","daniell","bonilla muñoz","123","STUDENT");
        mockMvc.perform(MockMvcRequestBuilders.post("/signup")
        .content(objectMapper.writeValueAsString(user)))
        .andExpect(view().name("login"));

    }
    @Test
    public void givenHomePageURI_whenMockMVC_thenReturnsIndexJSPViewName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/signup"))
                .andExpect(view().name("signup"));
    }
}