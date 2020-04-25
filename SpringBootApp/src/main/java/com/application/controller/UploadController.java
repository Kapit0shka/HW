package com.application.controller;

import com.application.db.FileDB;
import com.application.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
public class UploadController {

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file")MultipartFile file,
                             @ModelAttribute User user) throws IOException {

        FileDB.appendFromFile(file, user);
        return "infoOfUser";
    }

}
