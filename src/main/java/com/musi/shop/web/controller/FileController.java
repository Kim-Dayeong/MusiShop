package com.musi.shop.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
public class FileController {


    private static final String UPLOAD_DIR = "/Users/kimdayeong/intelij/Musishop/src/main/resources/static/uploads";

    @GetMapping("/upload")
    public String showUploadPage(Model model) {
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadFileAndJson(
            @RequestParam("file") MultipartFile file,
            @RequestParam("json") String json,
            Model model
    ) {
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload");
            return "upload";
        }

        try {
            // Save the file to the server
            Path uploadPath = Path.of(UPLOAD_DIR);
            Files.createDirectories(uploadPath);
            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
            String uniqueFilename = UUID.randomUUID().toString() + extension;
            Path filePath = uploadPath.resolve(uniqueFilename);

            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);


            model.addAttribute("message", "File and JSON uploaded successfully");
            System.out.println("Received 파일: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Failed to upload file and JSON");
        }

        // Process the JSON data (you can use a JSON library like Jackson or Gson)
        // For simplicity, we just print the JSON data to the console in this example
        System.out.println("Received JSON: " + json);

        return "upload";
    }
}