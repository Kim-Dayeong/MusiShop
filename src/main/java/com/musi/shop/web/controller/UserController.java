package com.musi.shop.web.controller;

import com.musi.shop.web.Service.UserService;
import com.musi.shop.web.entity.User;
import com.musi.shop.web.web.dto.UserFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//import javax.validation.Valid;
import javax.validation.Valid;
import java.io.IOException;


@RequiredArgsConstructor
@RequestMapping("/user")

@Controller
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;



    @PostMapping(value ="signup")
    public String userJoin(@Valid UserFormDto userFormDto, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            System.out.println("가입 오류!!!!!!!"+bindingResult);

            return "userForm";
        }
        try{
            User user = User.createUser(userFormDto, passwordEncoder);
            userService.saveUser(user);
            System.out.println("성공!!!!!!!");
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            System.out.println("에러2!!!!!!");
            return "userForm";
        }
        return "redirect:/";
    }





}







