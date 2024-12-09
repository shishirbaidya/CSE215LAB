package com.project.demo;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FacultyView {
    private static final String FILE_PATH = "FacultyDataBase.dat"; //Common file path for all faculties
    public static ArrayList<Faculty_Course> loadFaculty() {
        ArrayList<Faculty_Course> facultyCourses = new ArrayList<>();
        File file = new File(CommonFilePath.createCommonFolder()+File.separator+FILE_PATH);
        if (!file.exists()) {
            System.out.println("No faculty data file found.");
            return facultyCourses;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Faculty_Course facultyCourse = (Faculty_Course) ois.readObject();
                    facultyCourses.add(facultyCourse);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to load faculty: " + e.getMessage());
        }
        return facultyCourses;
    }
    public static ArrayList<String> loadFacultyCourse() {
        ArrayList<String> facultyCourses = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("No faculty data file found.");
            return facultyCourses;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Faculty_Course facultyCourse = (Faculty_Course) ois.readObject();
                    facultyCourses.add(facultyCourse.getFacultyCourse());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to load faculty: " + e.getMessage());
        }
        return facultyCourses;
    }
    public static ArrayList<String> loadCourseDetails() {
        ArrayList<String> courseDetails = new ArrayList<>();
        File file = new File(CommonFilePath.createCommonFolder()+File.separator+FILE_PATH);
        if (!file.exists()) {
            System.out.println("No faculty data file found.");
            return courseDetails;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Faculty_Course facultyCourse = (Faculty_Course) ois.readObject();
                    String courseDetail = facultyCourse.getFacultyCourse() + "."
                            + facultyCourse.getSection() + "--"
                            + facultyCourse.getFacultyInitial();
                    courseDetails.add(courseDetail);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to load course details: " + e.getMessage());
        }
        return courseDetails;
    }
}
