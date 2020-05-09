package com.application.db;

import com.application.model.SearchUser;
import com.application.model.User;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.http.HttpRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.UUID;

public class FileDB {

    public static void appendUser(String userInfo) throws IOException {

        File db = new File("db.txt");
        if(!db.exists()){
            db.mkdir();
        }

        try {
            FileWriter fr = new FileWriter(db, true);
            fr.append(userInfo);
            fr.close();
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void appendFromFile(MultipartFile file, User user) throws IOException {

        String uploadPath = "C:/Users/voa/IdeaProjects/SpringBootApp/uploadFile";
        String resultFileName;
        if (file != null) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            try {

                String uuidFile = UUID.randomUUID().toString();
                resultFileName = uploadPath + "/" + uuidFile + "." + file.getOriginalFilename();
                file.transferTo(new File(resultFileName));

                BufferedReader reader = new BufferedReader(new FileReader(resultFileName));
                String line = reader.readLine() + "\n";
                System.out.println(line);
                appendUser(line);

                String[] temp = line.split(" ");
                user.setSurname(temp[0]);
                user.setName(temp[1]);
                user.setMiddleName(temp[2]);
                user.setAge(Integer.parseInt(temp[3]));
                user.setSalary(Integer.parseInt(temp[4]));
                user.setEmail(temp[5]);
                user.setPlaceOfWork(temp[6]);
                user.setPhoneNumber(temp[7]);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String userSearch(SearchUser searchUser, HttpServletRequest request) throws IOException {

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
            return "404";
        }

        return "nothingFound";
    }
}
