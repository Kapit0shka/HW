package com.application.controller;

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
    public String searchUserSubmit(@ModelAttribute SearchUser searchUser, HttpServletRequest request)throws IOException {

        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));

        try {
            BufferedReader reader = new BufferedReader(new FileReader("db.txt"));

            String line = reader.readLine();
            do {
                if (line.toLowerCase().contains((searchUser.getSurname() + " " + searchUser.getName()).toLowerCase())){
                    String[] temp = line.split(" ");
                    searchUser.setMiddleName(temp[2]);
                    searchUser.setAge(Integer.parseInt(temp[3]));
                    searchUser.setSalary(Integer.parseInt(temp[4]));
                    searchUser.setEmail(temp[5]);
                    searchUser.setPlaceOfWork(temp[6]);
                    searchUser.setPhoneNumber(temp[7]);
                    searchUser.setUserAgent(userAgent.toString());
                    searchUser.setTime((new Date()).toString());
                    return "resultSearch";
                }
                line = reader.readLine();
            }
            while (line != null);
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        return "nothingFound";
    }



}
