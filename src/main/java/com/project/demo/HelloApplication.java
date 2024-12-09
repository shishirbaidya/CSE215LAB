package com.project.demo;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage primaryStage;
    public void start(Stage stage) {
        primaryStage = stage;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1280, 720);
            primaryStage.setTitle("StudentPortal");
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(loadIcon(getClass().getResource("/image/new1.png").toExternalForm()));
            primaryStage.setResizable(false);
            primaryStage.show();

            PauseTransition pause = new PauseTransition(Duration.seconds(2.9));
            pause.setOnFinished(event -> switchToNewScene(primaryStage));
            pause.play();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    //transfer the stage into other controller class
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    //to get title icon
    private Image loadIcon(String path) {
        return new Image(path);
    }
    //switching scene to selection menu admin/user
    public void switchToNewScene(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("new-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1280, 720);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

}
