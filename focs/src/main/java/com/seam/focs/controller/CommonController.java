package com.seam.focs.controller;

import com.seam.focs.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/common")
public class CommonController {

    @Value("${seam.path}")
    private String basePath;

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file){
        //file is a temporary file that needs to be dumped to a specified location,
        //otherwise the temporary file will be deleted after this request is completed.
        log.info(file.toString());

        //Original File Name
        String originalFilename = file.getOriginalFilename();           //abc.jpg
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        //Use UUID to regenerate file names to prevent file overwriting due to duplicate file names
        String fileName = UUID.randomUUID().toString() + suffix;        //dfsdfdfd.jpg

        //Create a directory based on set basePath
        File dir = new File(basePath);
        //Determine the existence of current directory
        if(!dir.exists()){
            //Targeted directory not exist, need to create one
            dir.mkdirs();
        }

        try {
            //Dump temporary files to a specified location
            file.transferTo(new File(basePath + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.success(fileName);
    }

    /**
     * Download File
     * @param name
     * @param response
     */
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response){

        try {
            //Read the content of the file through the input stream
            FileInputStream fileInputStream = new FileInputStream(new File(basePath + name));

            //Through the output stream to write the file back to the browser
            ServletOutputStream outputStream = response.getOutputStream();

            response.setContentType("image/jpeg");

            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }

            //Close resources
            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
