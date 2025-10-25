package com.example.fdhbankatmsimulator;

import com.example.fdhbankatmsimulator.backend.StageOneData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateAccountController {

    @FXML
    private TextField textName, textFname, textEmail, textAddress, textCity, textPin, textState;

    @FXML
    private DatePicker dateChooser;

    @FXML
    private RadioButton male, female, others, married, unmarried;

    @FXML
    private ToggleGroup genderGroup, maritalGroup;

    @FXML
    private Button nextBtn;

    public static StageOneData[] stageOneList;

    @FXML
    protected void backBtn(ActionEvent actionEvent){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    protected void onNextClicked(ActionEvent actionEvent) {
        if (isFormValid()) {
            Toggle selectedMarital = maritalGroup.getSelectedToggle();
            Toggle selectedGender = genderGroup.getSelectedToggle();

            String status = "";
            String gender = "";
            if (selectedMarital != null) {
                RadioButton selected = (RadioButton) selectedMarital;
                status = selected.getText();
            }
            if (selectedMarital != null) {
                RadioButton selected = (RadioButton) selectedMarital;
                gender = selected.getText();
            }

//            create Stage One object
            StageOneData stageOneData = new StageOneData(textName.getText(), textFname.getText(), textEmail.getText(), textAddress.getText(), textCity.getText(), textPin.getText(), textState.getText(), dateChooser.getValue(), gender, status);
            stageOneList = new StageOneData[]{stageOneData};

//            go to the next stage
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("create-account-view2.fxml"));
                Parent newSceneRoot = fxmlLoader.load();

                Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                currentStage.setResizable(false);
                currentStage.setScene(new Scene(newSceneRoot));
                currentStage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Show alert if form is incomplete
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Form Incomplete");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all required fields before proceeding.");
            alert.showAndWait();
        }
    }

    private boolean isFormValid() {
        // Check text fields
        if (textName.getText().isEmpty() ||
                textFname.getText().isEmpty() ||
                textEmail.getText().isEmpty() ||
                textAddress.getText().isEmpty() ||
                textCity.getText().isEmpty() ||
                textPin.getText().isEmpty() ||
                textState.getText().isEmpty()) {
            return false;
        }

        // Check date
        if (dateChooser.getValue() == null) {
            return false;
        }

        // Check gender
        if (genderGroup.getSelectedToggle() == null) {
            return false;
        }

        // Check marital status
        if (maritalGroup.getSelectedToggle() == null) {
            return false;
        }

        return true; // all fields are valid
    }
}
