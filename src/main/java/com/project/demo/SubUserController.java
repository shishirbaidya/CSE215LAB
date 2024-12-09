package com.project.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.util.*;
import javafx.fxml.Initializable;
import javafx.util.Callback;

public class SubUserController implements Initializable {
    //users sceneChange button
    private static String mainStudentID;

    public void setMainStudnetID(String password) {
        mainStudentID = password;
    }

    @FXML
    Text reminder;
    @FXML
    private Button Profile;
    @FXML
    private Button courseDetails;
    @FXML
    private Button attendance;
    @FXML
    private Button CGPA;
    @FXML
    private Button Fee;
    @FXML
    private Button facultyReview;
    @FXML
    private Button logout;
    @FXML
    private Button courseSelect;
    //label for all userid
    @FXML
    private Label idlabel;
    @FXML
    Stage stage = HelloApplication.getPrimaryStage();

    @FXML
    public void switchScene(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1280, 720);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void methodCourseDetails(ActionEvent event) {
        switchScene("userCourseDetails.fxml");
    }

    @FXML
    public void methodProfile(ActionEvent event) {
        switchScene("user1.fxml");
    }

    @FXML
    public void methodLogout(ActionEvent event) {
        switchScene("new-view.fxml");
    }

    @FXML
    public void methodCourseSelect(ActionEvent event) {
        switchScene("userCourseSelect.fxml");
    }

    @FXML
    public void methodFacultyReview(ActionEvent event) {
        switchScene("userFacultyReview.fxml");
    }

    @FXML
    public void methodAttendance(ActionEvent event) {
        switchScene("userAttendance.fxml");
    }

    @FXML
    public void methodCGPA(ActionEvent event) {
        switchScene("userCGPA.fxml");
    }

    @FXML
    public void methodFee(ActionEvent event) {
        switchScene("userFee.fxml");
    }

    @FXML
    Label course1;
    @FXML
    Label course2;
    @FXML
    Label course3;
    //AdvisingCourse
    @FXML
    private ListView<String> CourseSectionView;
    @FXML
    private Button courseAddend;
    @FXML
    private Button confirmAdvising;
    @FXML
    private TextArea SelectedCourseList;//show selected course
    protected String[] finalcourse = new String[3];
    ArrayList<String> facuous = FacultyView.loadCourseDetails();//this will load course details from the file
    private final ObservableList<String> facuCourse = FXCollections.observableArrayList(facuous);
    //METHOD FOR ADDING COUSE ----ADVISNG
    int idx = 0;
    int count = 0;//This will check how many courses im adding

    private final String isADvised = mainStudentID + "isADVISED" + ".txt";//---FOr advinsg checking
    private final String ADVISED_DATA = mainStudentID + "COURSE" + ".dat";
    String GRADE_DATA=mainStudentID+"previouscourse.dat";


    @FXML
    void handleAddCourse(ActionEvent event) throws IOException {
        if (count >= finalcourse.length) {
            ShowAlert("YOU CAN'T ADD MORE COURSES.");
            courseAddend.setDisable(true);
            return;
        }
        String selectedCourse = CourseSectionView.getSelectionModel().getSelectedItem();
        if (selectedCourse == null || selectedCourse.isEmpty()) {
            ShowAlert("No course selected. Please select a course to add.");
            return;
        }
        reminder.setVisible(true);

        finalcourse[idx] = selectedCourse;
        SelectedCourseList.appendText(selectedCourse + "\n");
        idx++;
        count++;
        System.out.println("Added course: " + selectedCourse);

        if (count == finalcourse.length) {
            ShowAlert("Course limit reached. You can't add more courses.");
            courseAddend.setDisable(true);
        }
    }


    @FXML
    void confirmAdvising(ActionEvent event) throws IOException { //##METHOD FOR CONFIRMING ADVISNIG--WILL STORE ADVISNG DATA IN FILE
        if (count == 0) {
            return;//Means no code selected..
        }
        AttendanceAndCourse obj = null;
        if (count == 1) {
            String input = finalcourse[0];

            String[] firstSplit = input.split("\\.");

            String part1 = firstSplit[0];//course name

            String[] secondSplit = firstSplit[1].split("--");

            String part2 = secondSplit[0];//section name
            String part3 = secondSplit[1];//faculty name

            obj = new AttendanceAndCourse(mainStudentID, part1, part2, part3);

        }
        if (count == 2) {
            String input = finalcourse[0];

            String[] firstSplit = input.split("\\.");

            String part1 = firstSplit[0];//course name

            String[] secondSplit = firstSplit[1].split("--");

            String part2 = secondSplit[0];//section name
            String part3 = secondSplit[1];//faculty name

            String input2 = finalcourse[1];

            String[] firstSplit2 = input2.split("\\.");

            String part21 = firstSplit2[0];//course name

            String[] secondSplit2 = firstSplit2[1].split("--");

            String part22 = secondSplit2[0];//section name
            String part23 = secondSplit2[1];//faculty name

            obj = new AttendanceAndCourse(mainStudentID, part1, part21, part2, part22, part3, part23);
        }
        if (count == 3) {
            String input = finalcourse[0];

            String[] firstSplit = input.split("\\.");

            String part1 = firstSplit[0];//course name

            String[] secondSplit = firstSplit[1].split("--");

            String part2 = secondSplit[0];//section name
            String part3 = secondSplit[1];//faculty name

            String input2 = finalcourse[1];

            String[] firstSplit2 = input2.split("\\.");

            String part21 = firstSplit2[0];//course name

            String[] secondSplit2 = firstSplit2[1].split("--");

            String part22 = secondSplit2[0];//section name
            String part23 = secondSplit2[1];//faculty name

            String input3 = finalcourse[2];

            String[] firstSplit3 = input3.split("\\.");

            String part31 = firstSplit3[0];//course name

            String[] secondSplit3 = firstSplit3[1].split("--");

            String part32 = secondSplit3[0];//section name
            String part33 = secondSplit3[1];//faculty name

            obj = new AttendanceAndCourse(mainStudentID, part1, part21, part31, part2, part22, part32, part3, part23, part33);
        }


        System.out.println("Confirming advising...");
        confirmAdvising.setDisable(true);
        courseAddend.setDisable(true);
        confirmAdvising.setText("Confirmed");

        // Combine the common folder path with the file name
        File file = new File(CommonFilePath.createCommonFolder() + File.separator + isADvised);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(1);
        fos.close();
        System.out.println(count);
        FileOutputStream fout = new FileOutputStream(CommonFilePath.createCommonFolder() + File.separator + ADVISED_DATA);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(obj);
        System.out.println("Selected copoourse just done writing in file");
        oos.close();

    }
    //initialize all label

    private int totalCourse;
    private String gender;

    // Create an ImageView to hold the selected image
    @FXML
    ImageView imageView1;

    //show grade

    @FXML
    Label gradecourse1;
    @FXML
    Label gradecourse2;
    @FXML
    Label gradecourse3;

    @FXML
    Label gerade1;
    @FXML
    Label gerade2;
    @FXML
    Label gerade3;

    String grade1;
    String grade2;
    String grade3;
    String gradcourse1;
    String gradcourse2;
    String gradcourse3;

    @FXML
    public void methodShowGrade(ActionEvent event){
        gradecourse1.setText(gradcourse1);
        gradecourse2.setText(gradcourse2);
        gradecourse3.setText(gradcourse3);
        gerade1.setText(grade1);
        gerade2.setText(grade2);
        gerade3.setText(grade3);

    }

    @FXML
    Label showCGPA;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(idlabel!=null){
            idlabel.setText(mainStudentID);
        }

        if(new File(CommonFilePath.createCommonFolder()+File.separator+isADvised).exists()) {
            try {
                FileInputStream fin = new FileInputStream(CommonFilePath.createCommonFolder()+File.separator+isADvised);//
                if (fin.read() == 1) {
                    if(courseAddend!=null) {
                        courseAddend.setDisable(true);
                        confirmAdvising.setDisable(true);
                        System.out.println("Cant advise");
                    }
                    fin.close();
                }
            } catch ( IOException _) {

            }
        }
        if(reminder!=null){
            reminder.setVisible(false);
        }
        try {

            File file = new File(CommonFilePath.createCommonFolder() + File.separator +mainStudentID+".dat");
            FileInputStream fin = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fin);
            Student currStudent;
            try {
                currStudent = (Student) ois.readObject();
                studentName.setText(currStudent.getName());
                studentID.setText(currStudent.getId());
                enrolledIN.setText(currStudent.getDept());
                Semester.setText(currStudent.getSem());
                //evaluationStatus.setText("Faculty Evaluation: " + currStudent.getSem());
                entryItem.setText("2024,SPRING");
                gender=currStudent.getGen();
            } catch (FileNotFoundException ex) {
                System.out.println("Error to read file.");
            }
            ois.close();
        } catch (Exception ex) {
            ex.getMessage();
        }
        if (CourseSectionView == null) {

            System.out.println("CourseSectionView is null!");
        } else {

            //LOOK GOOD
            CourseSectionView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
                @Override
                public ListCell<String> call(ListView<String> listView) {
                    return new ListCell<String>() {
                        @Override
                        protected void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty || item == null) {
                                setText(null); // Clear cell if empty
                                setGraphic(null);
                            } else {
                                // Customize text
                                Text text = new Text(item);
                                text.setFont(Font.font("Arial", 16)); // Set font size and family
                                text.setStyle("-fx-fill:#d35400"); // Set text color (CSS)
                                setGraphic(text); // Add styled text as graphic
                            }
                        }
                    };
                }
            });

            CourseSectionView.setItems(facuCourse);//show courses in listview
        }
        File check=new File(CommonFilePath.createCommonFolder()+File.separator + ADVISED_DATA);
        if(check.exists()) {
            try {

                // Combine the common folder path with the file name
                File file1 = new File(CommonFilePath.createCommonFolder()+ File.separator + ADVISED_DATA);

                if (!file1.exists() || file1.length() == 0) {
                    throw new EOFException("File is empty or does not exist.");
                }
                try (FileInputStream fin1 = new FileInputStream(file1);
                     ObjectInputStream ois1 = new ObjectInputStream(fin1)) {
                    AttendanceAndCourse currStudentCourse = (AttendanceAndCourse) ois1.readObject();

                    totalCourse=currStudentCourse.getTotalCourse();

                    fes1=currStudentCourse.getfestats1();
                    fes2=currStudentCourse.getfestats2();
                    fes3=currStudentCourse.getfestats3();

                    if (currStudentCourse.getTotalCourse() == 1) {
                        if (course1 != null) {
                            course1.setText(currStudentCourse.getCourse1());
                        }

                        if (section1 != null) {
                            section1.setText(currStudentCourse.getSection1());
                        }

                        if (facultyName1 != null) {
                            facultyName1.setText(currStudentCourse.getFaculty1());
                        }
                        if (ca1 != null) {
                            ca1.setText(String.valueOf(currStudentCourse.getClassAttendance1()));
                        }
                        if (ma1 != null) {
                            ma1.setText(String.valueOf(currStudentCourse.getMissingClass1()));
                        }

                        if(feStatus1!=null){
                            if(!currStudentCourse.getfestats1()){
                                feStatus1.setText("No");
                            }else{
                                feStatus1.setText("Yes");
                            }
                        }


                    } else if (currStudentCourse.getTotalCourse() == 2) {
                        if (course1 != null) {
                            course1.setText(currStudentCourse.getCourse1());
                        }
                        if (section1 != null) {
                            section1.setText(currStudentCourse.getSection1());
                        }
                        if (facultyName1 != null) {
                            facultyName1.setText(currStudentCourse.getFaculty1());
                        }
                        if (course2 != null) {
                            course2.setText(currStudentCourse.getCourse2());
                        }
                        if (section2 != null) {
                            section2.setText(currStudentCourse.getSection2());
                        }
                        if (facultyName2 != null) {
                            facultyName2.setText(currStudentCourse.getFaculty2());
                        }
                        if (ca1 != null) {
                            ca1.setText(String.valueOf(currStudentCourse.getClassAttendance1()));
                        }
                        if (ma1 != null) {
                            ma1.setText(String.valueOf(currStudentCourse.getMissingClass1()));
                        }
                        if (ca2 != null) {
                            ca2.setText(String.valueOf(currStudentCourse.getClassAttendance2()));
                        }
                        if (ma2 != null) {
                            ma2.setText(String.valueOf(currStudentCourse.getMissingClass2()));
                        }

                        if(feStatus1!=null){
                            if(!currStudentCourse.getfestats1()){
                                feStatus1.setText("No");
                            }else{
                                feStatus1.setText("Yes");
                            }
                        }

                        if(feStatus2!=null){
                            if(!currStudentCourse.getfestats2()){
                                feStatus2.setText("No");
                            }else{
                                feStatus2.setText("Yes");
                            }
                        }

                    } else if (currStudentCourse.getTotalCourse() == 3) {
                        if (course1 != null) {
                            course1.setText(currStudentCourse.getCourse1());
                        }
                        if (section1 != null) {
                            section1.setText(currStudentCourse.getSection1());
                        }
                        if (facultyName1 != null) {
                            facultyName1.setText(currStudentCourse.getFaculty1());
                        }
                        //
                        if (course2 != null) {
                            course2.setText(currStudentCourse.getCourse2());
                        }
                        if (section2 != null) {
                            section2.setText(currStudentCourse.getSection2());
                        }
                        if (facultyName2 != null) {
                            facultyName2.setText(currStudentCourse.getFaculty2());
                        }
                        //
                        if (course3 != null) {
                            course3.setText(currStudentCourse.getCourse3());
                        }
                        if (section3 != null) {
                            section3.setText(currStudentCourse.getSection3());
                        }
                        if (facultyName3 != null) {
                            facultyName3.setText(currStudentCourse.getFaculty3());
                        }
                        if (ca1 != null) {
                            ca1.setText(String.valueOf(currStudentCourse.getClassAttendance1()));
                        }
                        if (ma1 != null) {
                            ma1.setText(String.valueOf(currStudentCourse.getMissingClass1()));
                        }
                        if (ca2 != null) {
                            ca2.setText(String.valueOf(currStudentCourse.getClassAttendance2()));
                        }
                        if (ma2 != null) {
                            ma2.setText(String.valueOf(currStudentCourse.getMissingClass2()));
                        }
                        if (ca3 != null) {
                            ca3.setText(String.valueOf(currStudentCourse.getClassAttendance3()));
                        }
                        if (ma3 != null) {
                            ma3.setText(String.valueOf(currStudentCourse.getMissingClass3()));
                        }

                        if(feStatus1!=null){
                            if(!currStudentCourse.getfestats1()){
                                feStatus1.setText("No");
                            }else{
                                feStatus1.setText("Yes");
                            }
                        }

                        if(feStatus2!=null){
                            if(!currStudentCourse.getfestats2()){
                                feStatus2.setText("No");
                            }else{
                                feStatus2.setText("Yes");
                            }
                        }

                        if(feStatus3!=null){
                            if(!currStudentCourse.getfestats3()){
                                feStatus3.setText("No");
                            }else{
                                feStatus3.setText("Yes");
                            }
                        }
                    }
                }
            } catch (ClassNotFoundException | IOException _) {

            }
        }

        try  {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CommonFilePath.createCommonFolder()+File.separator+"notification.dat"));
            Notification notification = (Notification) ois.readObject();
            isFacultyEvaluationStarted=notification.isFeStatus();
            if(isFacultyEvaluationStarted){
                if(evaluationStatus!=null) {
                    evaluationStatus.setText("Faculty Evaluation: " + Semester.getText());
                }
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("EOF");
        }

        if (gender != null) {
            if (gender.equals("Female")) {
                imageView1.setImage(new Image(getClass().getResourceAsStream("/image/female.png")));
            } else {
                imageView1.setImage(new Image(getClass().getResourceAsStream("/image/male.png")));
            }
        } else {
            System.out.println("Gender is null!");
        }

        //Grade show

        File grad=new File(CommonFilePath.createCommonFolder()+File.separator + GRADE_DATA);
        if(grad.exists()) {
            try {

                File file1 = new File(CommonFilePath.createCommonFolder()+ File.separator + GRADE_DATA);

                if (!file1.exists() || file1.length() == 0) {
                    throw new EOFException("File is empty or does not exist.");
                }
                try (FileInputStream fin1 = new FileInputStream(file1);
                     ObjectInputStream ois1 = new ObjectInputStream(fin1)) {
                    PreviousGrade pg = (PreviousGrade) ois1.readObject();
                    grade1=pg.getCourse1grade();
                    grade2=pg.getCourse2grade();
                    grade3=pg.getCours3grade();
                    gradcourse1=pg.getCourse1();
                    gradcourse2=pg.getCourse2();
                    gradcourse3=pg.getCourse3();
                    showCGPA.setText(String.valueOf(pg.getCGPA()));

                }catch (Exception ex){
                    ex.getMessage();
                }
            }catch (Exception ex){
                ex.getMessage();
            }
        }

    }
    //important label
    @FXML
    private Label studentName;
    @FXML
    private Label studentID;
    @FXML
    private Label enrolledIN;
    @FXML
    private Label entryItem;
    @FXML
    Label Semester;

    @FXML
    Label section1;
    @FXML
    Label section2;
    @FXML
    Label section3;


    @FXML
    Label facultyName1;
    @FXML
    Label facultyName2;
    @FXML
    Label facultyName3;

    //Faculty Evaluation
    @FXML
    Label evaluationStatus;
    @FXML
    Label feStatus1;
    @FXML
    Label feStatus2;
    @FXML
    Label feStatus3;

    //Attendance
    @FXML
    Label ca1;//class attendance
    @FXML
    Label ca2;
    @FXML
    Label ca3;

    @FXML
    Label ma1;// missing class attendance
    @FXML
    Label ma2;
    @FXML
    Label ma3;

    @FXML
    Button febutton1;
    @FXML
    Button febutton2;
    @FXML
    Button febutton3;

    boolean fes1;
    boolean fes2;
    boolean fes3;

    @FXML
    public void methodFacultyEvaluation1(ActionEvent event) throws FileNotFoundException {//if else will be check if status is yes or no
        if(isFacultyEvaluationStarted&&!fes1&&(totalCourse>=1)){
            File file = new File(CommonFilePath.createCommonFolder()+File.separator+ADVISED_DATA);

            if (file.exists()) {
                AttendanceAndCourse anc;
                if (file.length() > 0) {
                    try (ObjectInputStream oins = new ObjectInputStream(new FileInputStream(file))) {
                        anc = (AttendanceAndCourse) oins.readObject();
                    } catch (IOException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    anc = new AttendanceAndCourse();
                }
                anc.setFestats1();
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                    oos.writeObject(anc);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                switchScene("facultyEvaluation.fxml");
            }
        }
    }
    @FXML
    public void methodFacultyEvaluation2(ActionEvent event) throws FileNotFoundException{
        if(isFacultyEvaluationStarted&&!fes2&&(totalCourse>=2)){
            File file = new File(CommonFilePath.createCommonFolder()+File.separator+ADVISED_DATA);

            if (file.exists()) {
                AttendanceAndCourse anc;
                if (file.length() > 0) {
                    try (ObjectInputStream oins = new ObjectInputStream(new FileInputStream(file))) {
                        anc = (AttendanceAndCourse) oins.readObject();
                    } catch (IOException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    anc = new AttendanceAndCourse();
                }
                anc.setFestats2();
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                    oos.writeObject(anc);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                switchScene("facultyEvaluation.fxml");
            }
        }
    }
    @FXML
    public void methodFacultyEvaluation3(ActionEvent event) throws FileNotFoundException,IOException{
        if(isFacultyEvaluationStarted&&!fes3&&(totalCourse>=3)){
            File file = new File(CommonFilePath.createCommonFolder()+File.separator+ADVISED_DATA);

            if (file.exists()) {
                AttendanceAndCourse anc;
                if (file.length() > 0) {
                    try (ObjectInputStream oins = new ObjectInputStream(new FileInputStream(file))) {
                        anc = (AttendanceAndCourse) oins.readObject();
                    } catch (IOException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    anc = new AttendanceAndCourse();
                }
                anc.setFestats3();
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                    oos.writeObject(anc);
                } catch (IOException _) {

                }

                switchScene("facultyEvaluation.fxml");
            }
        }
    }

    //notifications
    @FXML
    private Button notification;
    @FXML
    public void methodNotification(ActionEvent event){
    }
    //settings
    @FXML
    private Button setting;
    @FXML
    public void methodSettings(ActionEvent event){
    }
    //feedback
    @FXML
    private Button feedback;
    @FXML
    public void methodFeedback(ActionEvent event){
    }
    //show notifications

    private boolean isFacultyEvaluationStarted;

    @FXML
    private void handleLoadButtonClick(ActionEvent event) throws IOException {
        StringBuilder notifications = new StringBuilder();
        String Filepath = CommonFilePath.createCommonFolder();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Filepath+File.separator+"notification.dat"))) {
            while (true) {
                Notification notification = (Notification) ois.readObject();
                notifications.append(notification.getMessage()).append("\n\n");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("EOF");
        }

        showNotificationsDialog(notifications.toString());
    }

    private void showNotificationsDialog(String notifications) {

        Label label = new Label(notifications);
        label.setWrapText(true);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notifications");
        alert.setHeaderText("Here are the latest notifications:");
        alert.getDialogPane().setContent(label);

        alert.showAndWait();
    }
    @FXML
    Label settotalFee;
    @FXML
    void masterCardPayment(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.WARNING,"No internet connection , cant use online process process.",ButtonType.CLOSE);
        alert.setTitle("NO INTERNET");
        alert.setHeaderText("Can't use online payment process.");
        alert.showAndWait();

    }
    @FXML
    void bikashPayment(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.WARNING,"No internet connection , cant use Bikash process.",ButtonType.CLOSE);
        alert.setTitle("NO INTERNET");
        alert.setHeaderText("Can't use Bikash process.");
        alert.showAndWait();
    }
    @FXML
    void visaPayment(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.WARNING,"No internet connection , cant use online process process.",ButtonType.CLOSE);
        alert.setTitle("NO INTERNET");
        alert.setHeaderText("Can't use online payment process.");
        alert.showAndWait();

    }
    @FXML
    Label Fee1;//19500TK
    @FXML
    Label Fee2;//19500TK
    @FXML
    Label Fee3;//19500TK
    @FXML
    Label COURSE1;
    @FXML
    Label COURSE2;
    @FXML
    Label COURSE3;


    @FXML
    protected  void showTotalFee(ActionEvent event) throws IOException {
        AttendanceAndCourse attendanceAndCourse = null;

        File file = new File(CommonFilePath.createCommonFolder()+File.separator+ADVISED_DATA);

        if (file.exists()) {
            System.out.println("As file exist that means student took course.");
            try {

                ObjectInputStream oins = new ObjectInputStream(new FileInputStream(file));
                attendanceAndCourse = (AttendanceAndCourse) oins.readObject();

                int total_course = attendanceAndCourse.getTotalCourse();
                totalCourse = total_course;
                System.out.println("Totlal course..:" + total_course);

                if (total_course == 1) {
                    COURSE1.setText(attendanceAndCourse.getCourse1());
                    Fee1.setText("19,500");
                    settotalFee.setText("23,450");

                }
                if (total_course == 2) {
                    COURSE1.setText(attendanceAndCourse.getCourse1());

                    COURSE2.setText(attendanceAndCourse.getCourse2());
                    Fee1.setText("19,500");
                    Fee2.setText("19,500");
                    settotalFee.setText("43,450");

                }
                if (total_course == 3) {
                    COURSE1.setText(attendanceAndCourse.getCourse1());


                    COURSE2.setText(attendanceAndCourse.getCourse2());
                    COURSE3.setText(attendanceAndCourse.getCourse3());

                    Fee1.setText("19,500");
                    Fee2.setText("19,500");
                    Fee3.setText("19,500");
                    settotalFee.setText("65,450");

                }

                oins.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("student didn't take course or student id dont exist");//label
        }

    }

    protected  void ShowAlert(String message){

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(message);
        alert.setTitle("Course Selection FUll.");
        alert.setHeaderText("Advising 2025 Spring.");
        alert.showAndWait();

    }

}
