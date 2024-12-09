package com.project.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AdminUserMenuController extends oopUser implements oopAdmin {
    //for switching scene in the same stage
    Stage stage=HelloApplication.getPrimaryStage();

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

    //admin and user login panel

    @FXML
    Label adminEmailInvalid;
    @FXML
    Label adminPasswordInvalid;
    @FXML
    private TextField autextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField visiblePasswordField;

    private boolean isPasswordVisible;

    public void initialize() {
        if(isPasswordVisible) {
            isPasswordVisible = false;
        }
        if(visiblePasswordField!=null){
            visiblePasswordField.setVisible(false);
        }
    }

    @FXML
    protected void togglePasswordVisibility() {
        if (isPasswordVisible) {
            passwordField.setText(visiblePasswordField.getText());
            passwordField.setVisible(true);
            visiblePasswordField.setVisible(false);
        } else {
            visiblePasswordField.setText(passwordField.getText());
            passwordField.setVisible(false);
            visiblePasswordField.setVisible(true);
        }
        isPasswordVisible = !isPasswordVisible;
    }

    @FXML @Override
    public void methodAdminLogin(ActionEvent event) {
        String email = autextField.getText();
        String password = isPasswordVisible ? visiblePasswordField.getText() : passwordField.getText();

        if (checkAdminEmail.equals(email)) {//oopAdmin interface checkAdminEmail
            if (checkAdminPass.equals(password)) {
                methodOpenCaptcha(event);
            } else {
                adminPasswordInvalid.setText("Invalid Password.");
                System.out.println("Incorrect password.");// change with dialoguebox or lable
            }
        } else {
            adminEmailInvalid.setText("Invalid email");
            System.out.println("Incorrect email.");// change with dialoguebox or lable
        }
    }

    //user login and id pass another class
    @FXML
    Label InvalidEmailOrPassword;
    @FXML @Override
    public void methodUserLogin(ActionEvent event){
        String email = autextField.getText();
        String password = isPasswordVisible ? visiblePasswordField.getText() : passwordField.getText();
        try {
            File file = new File(CommonFilePath.createCommonFolder()+File.separator+"userdata.txt");
            if (!file.exists()) {
                throw new Exception("User not found!");
            } else {
                Scanner scanner = new Scanner(file);
                while(scanner.hasNext()) {
                    String[] user = scanner.nextLine().split(" ");
                    if (user[0].equals(email) && user[1].equals(password)) {
                        SubUserController su=new SubUserController();
                        su.setMainStudnetID(password);
                        methodUserOpenCaptcha(event);
                    }
                    InvalidEmailOrPassword.setText("Invalid email or password.");

                }
                throw new Exception("User not found!");}
        } catch (Exception _) {

        }
    }

    // Admin and user login and CAPTCHA

    private boolean adminBoolean0 = false;
    private boolean adminBoolean1 = false;
    private boolean adminBoolean2 = false;
    private boolean adminBoolean3 = false;
    private boolean adminBoolean4 = false;
    private boolean adminBoolean5 = false;
    private boolean adminBoolean6 = false;
    private boolean adminBoolean7 = false;
    private boolean adminBoolean8 = false;

    private  int count0;
    private  int count1;
    private  int count2;
    private  int count3;
    private  int count4;
    private  int count5;
    private  int count6;
    private  int count7;
    private  int count8;

    @FXML
    public void methodeButton0(ActionEvent event) {
        if(count0%2==0){
            adminBoolean0 = true;
            count0++;
        }else {
            adminBoolean0 = false;
            count0++;
        }
    }
    @FXML
    public void methodeButton1(ActionEvent event) {
        if(count1%2==0){
            adminBoolean1 = true;
            count1++;
        }else {
            adminBoolean1 = false;
            count1++;
        }
    }
    @FXML
    public void methodeButton2(ActionEvent event) {
        if(count2%2==0){
            adminBoolean2 = true;
            count2++;
        }else {
            adminBoolean2 = false;
            count2++;
        }
    }
    @FXML
    public void methodeButton3(ActionEvent event) {
        if(count3%2==0){
            adminBoolean3 = true;
            count3++;
        }else {
            adminBoolean3 = false;
            count3++;
        }
    }
    @FXML
    public void methodeButton4(ActionEvent event) {
        if(count4%2==0){
            adminBoolean4 = true;
            count4++;
        }else {
            adminBoolean4 = false;
            count4++;
        }
    }
    @FXML
    public void methodeButton5(ActionEvent event) {
        if(count5%2==0){
            adminBoolean5 = true;
            count5++;
        }else {
            adminBoolean5 = false;
            count5++;
        }
    }
    @FXML
    public void methodeButton6(ActionEvent event) {
        if(count6%2==0){
            adminBoolean6 = true;
            count6++;
        }else {
            adminBoolean6 = false;
            count6++;
        }
    }
    @FXML
    public void methodeButton7(ActionEvent event) {
        if(count7%2==0){
            adminBoolean7 = true;
            count7++;
        }else {
            adminBoolean7 = false;
            count7++;
        }
    }
    @FXML
    public void methodeButton8(ActionEvent event) {
        if(count8%2==0){
            adminBoolean8 = true;
            count8++;
        }else {
            adminBoolean8 = false;
            count8++;
        }
    }

    public void methodOpenCaptcha(ActionEvent event) {
        switchScene("adminCaptcha.fxml");
    }
    @FXML
    Label adminwrongCaptcha;
    @FXML @Override
    public void methodAdminLoginCaptcha(ActionEvent event) {
        if (adminBoolean0&&adminBoolean1&&adminBoolean5&&adminBoolean8&&!adminBoolean2&&!adminBoolean3&&!adminBoolean4&&!adminBoolean6&&!adminBoolean7) {
            switchScene("admin1.fxml");
        } else {
            adminwrongCaptcha.setVisible(true);
            System.out.println("Access denied.");// label add
        }
        adminBoolean0=adminBoolean1=adminBoolean2=adminBoolean3=adminBoolean4=adminBoolean5=adminBoolean6=adminBoolean7=adminBoolean8=false;
        count0=count1=count2=count3=count4=count5=count6=count7=count8=0;
    }
    @FXML
    Label wrongusercaptcha;
    //user
    public void methodUserOpenCaptcha(ActionEvent event) {
        switchScene("userCaptcha.fxml");
    }
    @FXML @Override
    public void methoduserLoginCaptcha(ActionEvent event) {
        if (adminBoolean0&&adminBoolean1&&adminBoolean5&&adminBoolean8&&!adminBoolean2&&!adminBoolean3&&!adminBoolean4&&!adminBoolean6&&!adminBoolean7) {
            switchScene("user1.fxml");
        } else {
            wrongusercaptcha.setVisible(true);
            System.out.println("Access denied.");// label add
        }
        adminBoolean0=adminBoolean1=adminBoolean2=adminBoolean3=adminBoolean4=adminBoolean5=adminBoolean6=adminBoolean7=adminBoolean8=false;
        count0=count1=count2=count3=count4=count5=count6=count7=count8=0;
    }
    //admin forget password
    @FXML @Override
    public void methodAdminForgotPassword(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.WARNING,"No Network Connection", ButtonType.CLOSE);
        alert.setTitle("Network Error!");
        alert.showAndWait();

    }
    //user forget password
    @FXML @Override
    public void methodUserForgotPassword(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.WARNING,"No Network Connection", ButtonType.CLOSE);
        alert.setTitle("Network Error!");
        alert.showAndWait();
    }

    @FXML
    private void nsuLink(ActionEvent event) throws IOException {
        Desktop desktop= Desktop.getDesktop();
        desktop.browse(java.net.URI.create("https://www.northsouth.edu"));
    }

}