package com.example.fdhbankatmsimulator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InqueriesController {

        @FXML
        public void viewBalanceBtn(ActionEvent actionEvent) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("account-balance.fxml"));
                Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        @FXML
        public void enterBtn(ActionEvent actionEvent) {
        }

        @FXML
        public void cancelBtn(ActionEvent actionEvent) {
        }

        @FXML
        public void backBtn(ActionEvent actionEvent) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("authorized-view.fxml"));
                Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        @FXML
        public void transcriptBtn(ActionEvent actionEvent) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("transcript-view.fxml"));
                Parent root = loader.load();

                // Create a new stage (popup)
                Stage popupStage = new Stage();
                popupStage.setTitle("Bank Transcript");
                popupStage.setScene(new Scene(root));

                Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                popupStage.initOwner(currentStage);

                popupStage.initModality(Modality.WINDOW_MODAL);

                popupStage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

}
