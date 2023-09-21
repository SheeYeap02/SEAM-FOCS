package com.seam.focs.controller;

import com.seam.focs.entity.DetailedInfo;
import com.seam.focs.service.DetailedInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/initData")
public class InitController {

    @Autowired
    private DetailedInfoService detailedInfoService;

    private List<DetailedInfo> initDetailedInfo() {
        List<DetailedInfo> detailedInfoList = new ArrayList<>();
        detailedInfoList.add(new DetailedInfo(1L, null, "T20 (RM9001 and above)", "Asthma", 1L));
        detailedInfoList.add(new DetailedInfo(2L, null, "M40 (RM5001 to RM9000)", "No", 2L));

        return detailedInfoList;
    }

    @PostMapping("/detailedInfo")
    protected void insertDetailedInfo() {
        String currentPath;
        List<String> imgPathList = new ArrayList<>();

        try {
            // Get the location of the class file of this java
            currentPath = this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            List<String> path = new ArrayList<>(Arrays.asList(currentPath.split("/")));

            /*
            E.g. Full Path:
            /C:/Users/Owner/Desktop/GroceriesSystem/build/web/WEB-INF/classes/InsertRecordToDB.class
             */
            for (int i = 1; i <= 5; i++) {
                // remove the last 5 pathway from the currentPath
                path.remove(path.size() - 1);
            }
            // Change the directory to the product image folder
            File detailedInfoFolder = new File(String.join(File.separator, path) + "/resources/dist/assets/image/DetailedInfo");
            listOfFiles(detailedInfoFolder, imgPathList);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }

        try {
            // Initialize all detailedInfo
            if(imgPathList.size() != 0) {
                List<DetailedInfo> detailedInfoList = initDetailedInfo();
                for (int i = 0; i < detailedInfoList.size(); i++) {
                    byte[] icFrontData = Files.readAllBytes(Path.of(imgPathList.get(i)));
                    detailedInfoList.get(i).setIcImage(icFrontData);
                }
                detailedInfoService.saveBatch(detailedInfoList);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    // This method is to list all files in a directory recursively
    public static void listOfFiles(File dirPath, List<String> imgPathList) throws IOException {
        if (dirPath == null) {
            System.out.println("It is null");
            return;
        }
//        PrintWriter out = response.getWriter();
        File[] filesList = dirPath.listFiles();

        assert filesList != null;
        for (File file : filesList) {
            if (file.isDirectory()) {
                // If is directory then will invoke itself again
                listOfFiles(file, imgPathList);
            } else {
                // Add the full path of image into the list
                imgPathList.add(file.getPath());
            }
        }
    }
}
