package com.example.fdhbankatmsimulator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Random;

public class BankFormPage2Controller {

    @FXML private ComboBox<String> religionBox, categoryBox, incomeBox, educationBox, occupationBox;
    @FXML private TextField panField;
    @FXML private RadioButton scYes, scNo, eaYes, eaNo;
    @FXML private Button submitBtn;

    static StageTwoData[]  stageTwoDataList;
    @FXML
    public void initialize() {
        religionBox.getItems().addAll("---select option---","Hindu", "Muslim", "Sikh", "Christian", "Other");
        categoryBox.getItems().addAll("---select option---","GENERAL", "OBC", "SC", "ST");
        incomeBox.getItems().addAll("---select option---","0 - 1,000,000 MK", "< 2,000,000 MK", "< 2,500,000 MK", "< 3,000,000 MK","< 4,000,000 MK", "< 5,000,000 Mk");
        educationBox.getItems().addAll("---select option---","Matrix", "Intermediate", "Graduate", "Post-Graduate", "Other");
        occupationBox.getItems().addAll("---select option---","Self-Employed", "Student", "Salaried", "Business", "House-Wife", "Retired", "Other");
    }

    @FXML
    private void handleSubmit() {
        if (religionBox.getValue() == null || categoryBox.getValue() == null ||
                incomeBox.getValue() == null || educationBox.getValue() == null ||
                occupationBox.getValue() == null || panField.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all fields before submitting");
            alert.showAndWait();
            return;
        }

        StageTwoData stageTwoData = new StageTwoData(religionBox.getValue(),incomeBox.getValue(), categoryBox.getValue(), educationBox.getValue(), occupationBox.getValue(), panField.getText(),true, false, CreateAccountController.stageOneList[0]);
        stageTwoDataList = new StageTwoData[]{stageTwoData};


        Alert success = new Alert(Alert.AlertType.INFORMATION, "Form submitted successfully");

        success.showAndWait();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("account-details-view.fxml"));
            Parent root = loader.load();


            // Get the correct controller
            AccountDetailsController nextController = loader.getController();
//            nextController.formNumber.setText("Form No : 2");

            Stage stage = (Stage) submitBtn.getScene().getWindow();
            stage.getScene().setRoot(root);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
