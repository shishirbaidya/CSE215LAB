package com.project.demo;
import java.io.*;

class Faculty_Course implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String facultycourse;
    private String Section;
    private String facultyName;
    private String facultyDept;
    private String facultyinitial;
    private String facultyId;

    public Faculty_Course(String facultycourse, String section, String facultyName, String facultyDept, String facultyinitial, String facultyId) {
        this.facultycourse = facultycourse;
        this.Section = section;
        this.facultyName = facultyName;
        this.facultyDept = facultyDept;
        this.facultyinitial = facultyinitial;
        this.facultyId = facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public void setFacultyDept(String facultyDept) {
        this.facultyDept = facultyDept;
    }

    public void setFacultyInitial(String facultyinitial) {
        this.facultyinitial = facultyinitial;
    }

    public void setFacultyCourse(String facultycourse) {
        this.facultycourse = facultycourse;
    }

    public void setSection(String section) {
        Section = section;
    }

    public String getFacultyCourse() {
        return facultycourse;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public String getSection() {
        return Section;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public String getFacultyDept() {
        return facultyDept;
    }

    public String getFacultyInitial() {
        return facultyinitial;
    }
}
public class FacultyAdder {
    private static final String FILE_PATH = "FacultyDataBase.dat";

    public static void addFaculty(Faculty_Course faculty_course) {
        File file = new File(CommonFilePath.createCommonFolder()+File.separator+FILE_PATH);
        boolean append = file.exists();

        try (ObjectOutputStream oos = append ?
                new AppendableObjectOutputStream(new FileOutputStream(file, true)) :
                new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(faculty_course);
        } catch (IOException e) {
            System.out.println("Failed to add faculty: " + e.getMessage());
        }
    }

    // Custom ObjectOutputStream to avoid writing a header when appending
    private static class AppendableObjectOutputStream extends ObjectOutputStream {
        AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            // Do not write a header when appending
        }
    }
}
