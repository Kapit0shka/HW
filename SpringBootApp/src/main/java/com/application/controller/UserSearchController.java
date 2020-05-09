package com.application.controller;

import com.application.db.FileDB;
import com.application.model.SearchUser;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

@Controller
public class UserSearchController {

    @GetMapping("/searchUser")
    public String createUserSearchForm(Model model) {
        model.addAttribute("searchUser", new SearchUser());
        return "searchUser";
    }

    @PostMapping("searchUser")
    public String searchUserSubmit(@ModelAttribute SearchUser searchUser, HttpServletRequest request) throws IOException {
        return FileDB.userSearch(searchUser,request);
    }
}
