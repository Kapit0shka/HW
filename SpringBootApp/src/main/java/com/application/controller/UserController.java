package com.application.controller;

import com.application.db.FileDB;
import com.application.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.*;

@Controller
public class UserController {

    @GetMapping("/createUser")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping("/createUser")
    public String userSubmit(@ModelAttribute @Valid User user, BindingResult bindingResult) throws IOException {

        if(bindingResult.hasErrors()) { return "createUser"; }

        String userInfo = user.getSurname() + " " +
                user.getName() + " " +
                user.getMiddleName() + " " +
                user.getAge() + " " +
                user.getSalary() + " " +
                user.getEmail() + " " +
                user.getPlaceOfWork() + " " +
                user.getPhoneNumber() + "\n";

        FileDB.appendUser(userInfo);
        return "infoOfUser";
    }
}
