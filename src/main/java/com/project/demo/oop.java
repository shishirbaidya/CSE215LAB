package com.project.demo;
import javafx.event.ActionEvent;

interface oopAdmin {
    String checkAdminEmail = "admin.1993@northsouth.edu"; //admin Email
    String checkAdminPass = "admin1993"; //admin password
    void methodAdminLogin(ActionEvent event);
    void methodAdminLoginCaptcha(ActionEvent event);
}
abstract class oopUser extends oppForgetPass{

    @Override
    public void methodAdminForgotPassword(ActionEvent event){
        System.out.println("Poor Network");
    }
    @Override
    public void methodUserForgotPassword(ActionEvent event){
        System.out.println("Poor Network");
    }

    abstract public void methodUserLogin(ActionEvent event);

    abstract public void methoduserLoginCaptcha(ActionEvent event);
}

class oppForgetPass{

    public void methodAdminForgotPassword(ActionEvent event){
        System.out.println("oppForgetPass");
    }

    public void methodUserForgotPassword(ActionEvent event){
        System.out.println("oppForgetPass");
    }

}
