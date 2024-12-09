package com.project.demo;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
public class HelloController {
    @FXML
    private Button admin;
    @FXML
    private Button user;
    @FXML
    private MediaView mediaView;
    @FXML
    Stage stage=HelloApplication.getPrimaryStage();

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
    private void switchAdmin(ActionEvent event) {
        switchScene("admin.fxml");
    }

    @FXML
    private void switchUser(ActionEvent event) {
        switchScene("user.fxml");
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    public void initialize() {
        if (mediaView != null) {
            String videoPath = getClass().getResource("/image/logo1.mp4").toExternalForm();
            Media media = new Media(videoPath);
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);

            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
        }
    }
}

