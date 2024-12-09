package com.project.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
public class SubAdminController implements Serializable ,Initializable {
    public static boolean containsDigit(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isValidDigitString(String str,int len) {
        if (str.length() != len) {
            return false;}
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean EmailAndIdExistence(File file, String email, String id) {
        if (!file.exists()) {
            return false;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(email) && line.contains(id)) {
                    return true;
                }
            }
        } catch (IOException _) {
            System.out.println("Error to check if student already exist.");
        }

        return false;
    }

    int totalCourse;
    @FXML
    Label initial1;
    @FXML
    Label initial2;
    @FXML
    Label initial3;
    @FXML
    AnchorPane attendecsheet;
    @FXML
    RadioButton present11;
    @FXML
    RadioButton present12;
    @FXML
    RadioButton present21;
    @FXML
    RadioButton present22;
    @FXML
    RadioButton present31;
    @FXML
    RadioButton present32;
    @FXML
    TextField studentIDsearch;
    @FXML
    Label AtstudentID;
    @FXML
    Button searchStudentButton;
    @FXML
    Button AtConfirmButton;
    @FXML
    Label Atcourse1;
    @FXML
    Label Atcourse2;
    @FXML
    Label Atcourse3;
    @FXML
    Label AtSec1;
    @FXML
    Label AtSec2;
    @FXML
    Label AtSec3;

    //searching student details for attendece__________
    @FXML
    private void searchStudentForAttendence(ActionEvent event) throws IOException {
        AttendanceAndCourse attendanceAndCourse = null;
        File file = new File(CommonFilePath.createCommonFolder()+File.separator+studentIDsearch.getText()+"COURSE.dat");

        if (file.exists()) {
            try {

                ObjectInputStream oins = new ObjectInputStream(new FileInputStream(file));
                attendanceAndCourse = (AttendanceAndCourse) oins.readObject();

                int total_course = attendanceAndCourse.getTotalCourse();
                totalCourse = total_course;
                AtstudentID.setText(attendanceAndCourse.getStudentID());

                if (total_course == 1) {
                    Atcourse1.setText(attendanceAndCourse.getCourse1());
                    AtSec1.setText(attendanceAndCourse.getSection1());
                    initial1.setText(attendanceAndCourse.getFaculty1());

                }
                if (total_course == 2) {
                    Atcourse1.setText(attendanceAndCourse.getCourse1());
                    AtSec1.setText(attendanceAndCourse.getSection1());
                    initial1.setText(attendanceAndCourse.getFaculty1());

                    Atcourse2.setText(attendanceAndCourse.getCourse2());
                    AtSec2.setText(attendanceAndCourse.getSection2());
                    initial2.setText(attendanceAndCourse.getFaculty2());


                }
                if (total_course == 3) {
                    Atcourse1.setText(attendanceAndCourse.getCourse1());
                    AtSec1.setText(attendanceAndCourse.getSection1());
                    initial1.setText(attendanceAndCourse.getFaculty1());

                    Atcourse2.setText(attendanceAndCourse.getCourse2());
                    AtSec2.setText(attendanceAndCourse.getSection2());
                    initial2.setText(attendanceAndCourse.getFaculty2());

                    Atcourse3.setText(attendanceAndCourse.getCourse3());
                    AtSec3.setText(attendanceAndCourse.getSection3());
                    initial3.setText(attendanceAndCourse.getFaculty3());
                }

                oins.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("student didn't take course or student id dont exist");//label
        }
    }

    //Confirming student attendence___________
    @FXML
    void AttendenceConfirm(ActionEvent event) throws IOException, ClassNotFoundException {
        File file = new File(CommonFilePath.createCommonFolder()+File.separator+studentIDsearch.getText()+"COURSE.dat");

        if (file.exists()) {

            AttendanceAndCourse anc;

            if (file.length() > 0) {
                try (ObjectInputStream oins = new ObjectInputStream(new FileInputStream(file))) {
                    anc = (AttendanceAndCourse) oins.readObject();
                }
            } else {
                anc = new AttendanceAndCourse();
            }

            if (totalCourse == 1) {
                if (present11.isSelected()) {
                    anc.setClassAttendance1(1);
                } else if (present12.isSelected()) {
                    anc.setMissingClass1(1);
                }
            } else if (totalCourse == 2) {
                if (present11.isSelected()) {
                    anc.setClassAttendance1(1);
                } else if (present12.isSelected()) {
                    anc.setMissingClass1(1);
                }
                if (present21.isSelected()) {
                    anc.setClassAttendance2(1);
                } else if (present22.isSelected()) {
                    anc.setMissingClass2(1);
                }
            } else if (totalCourse == 3) {
                if (present11.isSelected()) {
                    anc.setClassAttendance1(1);
                } else if (present12.isSelected()) {
                    anc.setMissingClass1(1);
                }
                if (present21.isSelected()) {
                    anc.setClassAttendance2(1);
                } else if (present22.isSelected()) {
                    anc.setMissingClass2(1);
                }
                if (present31.isSelected()) {
                    anc.setClassAttendance3(1);
                } else if (present32.isSelected()) {
                    anc.setMissingClass3(1);
                }
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(anc);
            } catch (IOException e) {
                e.printStackTrace();
            }

            AtConfirmButton.setText("Done");
            AtConfirmButton.setDisable(true);
        }else {
            System.out.println("error");
        }
    }
    //Faculty TextFiled that will take date are below
    @FXML
    private TextField FacultyDepartment;
    @FXML
    private TextField CourseInit;
    @FXML
    private TextField facultyId;
    @FXML
    private TextField facultyInitial;
    @FXML
    private TextField facultyName;
    @FXML
    private Button confirmF;
    //Section information
    @FXML
    private RadioButton Section1;
    @FXML
    private ToggleGroup Section;
    @FXML
    private RadioButton Section2;
    @FXML
    private Label CourseSection;

    @FXML
    void getCourseSection() {
        if (Section1.isSelected()) {
            CourseSection.setText(Section1.getText());
        } else if (Section2.isSelected()) {
            CourseSection.setText(Section2.getText());
        }

    }
    //Store value of faculty UI
    String FName;
    String FInit;
    String FId;
    String FDept;
    String FCourse;
    String Fsect;

    @FXML
    private void confirmFacultyCourse() throws IOException {
        if (facultyName.getText().isEmpty() || //For checking if data not entered..
                facultyId.getText().isEmpty() ||
                facultyInitial.getText().isEmpty() ||
                FacultyDepartment.getText().isEmpty()||
                CourseInit.getText().isEmpty()
        ) {
            //If all field text are not given then this will arrive
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setResizable(false);
            alert.setTitle("Missing Data");
            alert.setHeaderText("Incomplete Information");
            alert.setContentText("Please add all information carefully.");
            alert.showAndWait();
            return;
        }
        if (containsDigit(facultyName.getText())||!(isValidDigitString(facultyId.getText(),7))) {//ID must be in 7 digit fixed.
          //For checking valid data.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setResizable(false);
            alert.setTitle("Missing Data");
            alert.setHeaderText("Incomplete Information");
            alert.setContentText("Please add all information carefully.");
            alert.showAndWait();
            return;
        }
        FName=facultyName.getText();
        FInit=facultyInitial.getText();
        FId=facultyId.getText();
        FDept=FacultyDepartment.getText();
        FCourse=CourseInit.getText();
        Fsect=CourseSection.getText();
        FacultyAdder.addFaculty(new Faculty_Course(FCourse,Fsect,FName,FDept,FInit,FId));

        //UI clear and fresh
        confirmF.setText("Confirmed");
        confirmF.setDisable(true);
        // confirmF.setVisible(false);
        facultyInitial.clear();
        facultyId.clear();
        facultyId.clear();
        FacultyDepartment.clear();
        facultyName.clear();
        CourseInit.clear();
    }
    //RegisterStudent information
    @FXML
    private TextField initialSemester;
    @FXML
    private TextField studentDepartment;
    @FXML
    private TextField studentName;
    @FXML
    private TextField studentid;
    @FXML
    private Button confirmS;

    //Gender information
    @FXML
    private RadioButton femaleGender;
    @FXML
    private ToggleGroup getGender;
    @FXML
    private RadioButton maleGender;
    @FXML
    private Label studentgender;


    //code for Switching scene
    @FXML
    Stage stage = HelloApplication.getPrimaryStage();
    //Register studentInfo
    String Semester;
    String Name;
    String Dept;
    String Id;

    public SubAdminController() throws IOException {
    }
    @FXML
    public void switchScene(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1280, 720);
            stage.setScene(scene);
            stage.show();

        } catch (IOException _) {
            System.out.println("Error to switch scene..");
        }
    }

    @FXML
    public void methodAddTeacher(ActionEvent event) {
        switchScene("addTeacher.fxml");
    }
    @FXML
    public void methodDasbord(ActionEvent event) {
        switchScene("admin1.fxml");
    }

    @FXML
    public void methodAddStudent(ActionEvent event) {
        switchScene("addStudent.fxml");
    }
    @FXML
    public void methodAddCourse(ActionEvent event) {
        switchScene("addCourse.fxml");
    }
    @FXML
    public void methodAddUpdate(ActionEvent event) {
        switchScene("addUpdate.fxml");
    }
    @FXML
    public void methodAddCGPA(ActionEvent event) {
        switchScene("AddCGPA.fxml");
    }
    @FXML
    public void methodAddAttendance(ActionEvent event) {
        switchScene("addAttendance.fxml");
    }
    @FXML
    public void methodLogout(ActionEvent event) {
        switchScene("new-view.fxml");
    }
    //Getting and setting gender
    @FXML
    void getGender() {
        if (maleGender.isSelected()) {
            studentgender.setText(maleGender.getText());
        } else if (femaleGender.isSelected()) {
            studentgender.setText(femaleGender.getText());
        }
    }
    @FXML
    String getGEN;
    String fileName = "userdata.txt";//Common file where all student id and password stored.
    // Combine the common folder path with the file name
    File file = new File(CommonFilePath.createCommonFolder() + File.separator + fileName);
    @FXML
    void confirmSTdetails() throws IOException  {
        if (initialSemester.getText().isEmpty() ||
                studentName.getText().isEmpty() ||
                studentDepartment.getText().isEmpty() ||
                studentgender.getText().isEmpty()) {
            //If all field text are not given then this will arrive
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setResizable(false);
            alert.setTitle("Wrong Data");
            alert.setHeaderText("Incomplete Information");
            alert.setContentText("Please add all information carefully.");
            studentid.clear();
            studentName.clear();
            studentDepartment.clear();

            alert.showAndWait();
            return;
        }
        if (containsDigit(studentName.getText()) || !(isValidDigitString(studentid.getText(),7 ))) {
            //Checking for valid data

            studentid.clear();
            studentName.clear();
            studentDepartment.clear();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setResizable(false);
            alert.setTitle("Incorrect student data");
            alert.setHeaderText("Incomplete Information");
            alert.setContentText("Please add valid  information carefully.");

            alert.showAndWait();
            return;
        }

        Semester = initialSemester.getText();
        Name =studentName.getText();
        Dept = studentDepartment.getText();
        getGEN = studentgender.getText();
        Id=studentid .getText();

        String[] parts = Name.split(" ", 2); // Split into two parts
        String firstPart = parts[0];
        //creating email and password for user
        String email=firstPart+"."+Id.trim()+"@northsouth.edu";
        if(EmailAndIdExistence(file,email,Id)){//this check if the student already exist?
            System.out.println("Student data already exist.can add same student id for another one.");
            return;
        }

        try {

            if (file.createNewFile()) {
                FileWriter add = new FileWriter(file);
                add.write(email + " " + Id + "\n");
                add.close();
            } else {
                FileWriter add = new FileWriter(file, true);
                add.write(email + " " + Id + "\n");
                add.close();
            }
        } catch (Exception ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
        String newfilename=Id+".dat";
        File files = new File(CommonFilePath.createCommonFolder() + File.separator + newfilename);
        if (files.createNewFile()) {
            System.out.println("File created: " + files.getAbsolutePath());
        } else {
            System.out.println("File already exists or failed to create.");
        }
        ObjectOutputStream obs = new ObjectOutputStream(new FileOutputStream(files));
        obs.writeObject(new Student(Name,Id,Dept,Semester,getGEN));
        obs.close();
        if (confirmS == null) {
            System.out.println("confirmS is null!");
        } else {
            confirmS.setText("Confirmed");
            //  wait(1000);
            confirmS.setVisible(false); //this will remove  confirm button & kindof force to remove
            initialSemester.clear();
            studentName.clear();
            studentid.clear();
            studentgender.setText("");
            studentDepartment.clear();
        }
        System.out.println("All DOne sucessfull");
    }

    //nofifiaction

    @FXML
    private TextField messageTextField;
    @FXML
    private RadioButton feStatusTrue;
    @FXML
    private RadioButton feStatusFalse;

    @FXML
    private void saveNotifications(ActionEvent event) {
        String msg = messageTextField.getText();
        Notification not = new Notification(msg);
        if(feStatusTrue.isSelected()){
            not.setFeStatus(true);
        }else if(feStatusFalse.isSelected()){
            not.setFeStatus(false);
        }

        try {
            String fileName = "notification.dat";
            File file = new File(CommonFilePath.createCommonFolder() + File.separator + fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(not);
        } catch (IOException _) {

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(attendecsheet!=null){
            attendecsheet.setVisible(true);
        }

    }
    //course and grade setting part--for previous course
    @FXML
    TextField previousCourse1;
    @FXML
    TextField previousCourse2;
    @FXML
    TextField previousCourse3;
    @FXML
    TextField gradePreviouseCourse1;
    @FXML
    TextField gradePreviouseCourse2;
    @FXML
    TextField gradePreviouseCourse3;


    //studentInformation part for setting previous semester grade!-------------------------
    @FXML
    Label successfullMessage;
    @FXML
    Label studentIdsearchedforPrev;
    @FXML
    TextField studntidsearchforpreviouscourseadd;//
    @FXML
    RadioButton RadiopreviouseCourse1;
    @FXML
    RadioButton RadiopreviouseCourse2;
    @FXML
    RadioButton RadiopreviouseCourse3;
    String selectedCourseNum;//Store course number of previous semester for calling correct constructor;
    void selectCourseByToggle(){

        if(RadiopreviouseCourse1.isSelected()){
            selectedCourseNum=RadiopreviouseCourse1.getText();
        }
        if(RadiopreviouseCourse2.isSelected()){
            selectedCourseNum=RadiopreviouseCourse2.getText();
        }
        if(RadiopreviouseCourse3.isSelected()){
            selectedCourseNum=RadiopreviouseCourse3.getText();
        }

    }
    @FXML
    Label warninglabel1;
    @FXML
    Label warninglabel2;
    @FXML
    Label warninglabel3;

    @FXML
    protected  void searchForAddPreviousCourse(ActionEvent event){
        try{
            File file = new File(CommonFilePath.createCommonFolder()+File.separator+studntidsearchforpreviouscourseadd.getText()+".dat");//by the filename we will check if the student avaiable.
            if(!file.exists()){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Student may not exist.",ButtonType.CLOSE);

                alert.showAndWait();
                return;
            }
            studentIdsearchedforPrev.setText(studntidsearchforpreviouscourseadd.getText());
            //  studentIdsearchedforPrev.se
        }catch (Exception _){
        }
    }
    //Confirming grade.
    @FXML
    Button buttonconfirmPreviousGradeAdd;
    @FXML
    void confirmPreviousGreadeAdd(ActionEvent event) throws IOException {
        selectCourseByToggle();
        System.out.println("Checking if can write.");
        File file = new File(CommonFilePath.createCommonFolder()+File.separator+String.valueOf(studentIdsearchedforPrev.getText())+"previouscourse.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        if(!file.exists()){
            file.createNewFile();
        }
        PreviousGrade previousGrade=null;
        if(selectedCourseNum.equals("1")){
            if(previousCourse1.getText().isEmpty() || gradePreviouseCourse1.getText().isEmpty()){
                warninglabel1.setVisible(true);
                return;
            }
            double CGPA = getGradePoint(gradePreviouseCourse1.getText());
            previousGrade = new PreviousGrade("Summer 20223",previousCourse1.getText(),gradePreviouseCourse1.getText(),1,CGPA);
        }else  if(selectedCourseNum.equals("2")){
            if(previousCourse1.getText().isEmpty() || previousCourse2.getText().isEmpty() ||gradePreviouseCourse1.getText().isEmpty()||gradePreviouseCourse1.getText().isEmpty()){
                warninglabel1.setVisible(true);
                return;
            }
            double CGPA = ((getGradePoint(gradePreviouseCourse1.getText()) + getGradePoint(gradePreviouseCourse2.getText())) * 3) / 6;

            previousGrade = new PreviousGrade("Summer2023",previousCourse1.getText(),previousCourse2.getText(),gradePreviouseCourse1.getText(),gradePreviouseCourse2.getText(),2,CGPA);

        }else if(selectedCourseNum.equals("3")){
            if(previousCourse1.getText().isEmpty() || previousCourse2.getText().isEmpty() ||previousCourse3.getText().isEmpty() ||gradePreviouseCourse1.getText().isEmpty()||gradePreviouseCourse1.getText().isEmpty()||gradePreviouseCourse1.getText().isEmpty()){
                warninglabel1.setVisible(true);
                return;
            }
            double CGPA = ((getGradePoint(gradePreviouseCourse1.getText()) + getGradePoint(gradePreviouseCourse2.getText()) + getGradePoint(gradePreviouseCourse3.getText())) * 3) / 9;

            previousGrade = new  PreviousGrade("Summer2023",previousCourse1.getText(),previousCourse2.getText(),previousCourse3.getText(),gradePreviouseCourse1.getText(),gradePreviouseCourse2.getText(),gradePreviouseCourse3.getText(),2,CGPA);

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Something went wrong to save details.",ButtonType.CANCEL);
            alert.setHeaderText("Error to save in File.");
            alert.showAndWait();
            return;
        }
        objectOutputStream.writeObject(previousGrade);
        objectOutputStream.close();
        objectOutputStream.flush();
        successfullMessage.setVisible(true);
        buttonconfirmPreviousGradeAdd.setText("Confirmed");
        buttonconfirmPreviousGradeAdd.setDisable(true);

    }

    private static double getGradePoint(String grade) {
        if (grade.equals("A")) {
            return 4.0;
        } else if (grade.equals("A-")) {
            return 3.7;
        } else if (grade.equals("B+")) {
            return 3.3;
        } else if (grade.equals("B")) {
            return 3.0;
        } else if (grade.equals("B-")) {
            return 2.7;
        } else if (grade.equals("C+")) {
            return 2.3;
        } else if (grade.equals("C")) {
            return 2.0;
        } else if (grade.equals("C-")) {
            return 1.7;
        } else if (grade.equals("D+")) {
            return 1.3;
        } else if (grade.equals("D")) {
            return 1.0;
        } else if (grade.equals("F")) {
            return 0.0;
        } else {
            return -1;
        }

    }
}