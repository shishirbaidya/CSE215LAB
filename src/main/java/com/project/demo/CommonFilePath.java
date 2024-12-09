package com.project.demo;
import java.io.File;
//For common folder in alsystem
public class CommonFilePath {
    public static String createCommonFolder() {
        String projectDirectory = System.getProperty("user.dir");
        String commonFolderPath = projectDirectory + File.separator + "Student_and_faculty_DATABASE";
        File folder = new File(commonFolderPath);
        if(!folder.exists()){
            folder.mkdir();
            System.out.println("Folder created.");
        }
        return commonFolderPath;
    }
}

