package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ViewController {


    @FXML
    ChoiceBox<String> materialAmount;

    @FXML
    TextField material1;

    @FXML
    TextField material2;

    @FXML
    TextField material3;

    @FXML
    ChoiceBox<String> requiredAmount;

    @FXML
    TextField amount1;

    @FXML
    TextField amount2;

    @FXML
    TextField amount3;

    /////////////////////////////////////////

    @FXML
    ChoiceBox<String> widthAmount;

    @FXML
    TextField width1;

    @FXML
    TextField width2;

    @FXML
    TextField width3;


    @FXML
    void initialize() {
        materialAmount.getItems().addAll(
                "1",
                "2",
                "3"
        );

        requiredAmount.getItems().addAll(
                "1",
                "2",
                "3"
        );

        widthAmount.getItems().addAll(
                "1",
                "2",
                "3"
        );

        materialAmount.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case "1":
                    material1.setVisible(true);
                    material2.setVisible(false);
                    material3.setVisible(false);
                    break;
                case "2":
                    material1.setVisible(true);
                    material2.setVisible(true);
                    material3.setVisible(false);
                    break;

                case "3":
                    material1.setVisible(true);
                    material2.setVisible(true);
                    material3.setVisible(true);
                    break;
            }
        });

        requiredAmount.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case "1":
                    material1.setVisible(true);
                    material2.setVisible(false);
                    material3.setVisible(false);
                    break;
                case "2":
                    material1.setVisible(true);
                    material2.setVisible(true);
                    material3.setVisible(false);
                    break;

                case "3":
                    material1.setVisible(true);
                    material2.setVisible(true);
                    material3.setVisible(true);
                    break;
            }
        });

        widthAmount.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case "1":
                    material1.setVisible(true);
                    material2.setVisible(false);
                    material3.setVisible(false);
                    break;
                case "2":
                    material1.setVisible(true);
                    material2.setVisible(true);
                    material3.setVisible(false);
                    break;

                case "3":
                    material1.setVisible(true);
                    material2.setVisible(true);
                    material3.setVisible(true);
                    break;
            }
        });
    }

}
