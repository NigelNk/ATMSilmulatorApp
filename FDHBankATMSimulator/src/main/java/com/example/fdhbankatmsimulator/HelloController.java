package com.example.fdhbankatmsimulator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    public void createAccount(ActionEvent actionEvent) {
        try {
            // Create a new FXMLLoader for the new scene's FXML file.
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("create-account-view.fxml"));
            Parent newSceneRoot = fxmlLoader.load();

            Stage currentStage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.setResizable(false);
            currentStage.setScene(new Scene(newSceneRoot));

            currentStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void useATM(ActionEvent actionEvent) {
        try {
            // Create a new FXMLLoader for the new scene's FXML file.
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("use-atm-view.fxml"));
            Parent newSceneRoot = fxmlLoader.load();

            Stage currentStage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.setResizable(false);
            currentStage.setScene(new Scene(newSceneRoot));

            currentStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
