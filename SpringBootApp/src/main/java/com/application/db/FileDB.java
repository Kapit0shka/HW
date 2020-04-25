package com.application.db;

import com.application.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
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
}
