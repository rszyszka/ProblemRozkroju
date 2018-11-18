package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

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
                    amount1.setVisible(true);
                    amount2.setVisible(false);
                    amount3.setVisible(false);
                    break;
                case "2":
                    amount1.setVisible(true);
                    amount2.setVisible(true);
                    amount3.setVisible(false);
                    break;

                case "3":
                    amount1.setVisible(true);
                    amount2.setVisible(true);
                    amount3.setVisible(true);
                    break;
            }
        });

        widthAmount.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case "1":
                    width1.setVisible(true);
                    width2.setVisible(false);
                    width3.setVisible(false);
                    break;
                case "2":
                    width1.setVisible(true);
                    width2.setVisible(true);
                    width3.setVisible(false);
                    break;

                case "3":
                    width1.setVisible(true);
                    width2.setVisible(true);
                    width3.setVisible(true);
                    break;
            }
        });
    }

    @FXML
    public void findSolutionAction(){

        System.out.println(getMaterialValue());
        System.out.println(getRequiredAmountValue());
        System.out.println(getWidthValue());

    }

    private List<Double> getMaterialValue(){
        List<Double> materials = new ArrayList<>();
        if(materialAmount.getValue() == "1"){
            materials.add(Double.parseDouble(material1.getText()));
        }

        if(materialAmount.getValue() == "2"){
            materials.add(Double.parseDouble(material1.getText()));
            materials.add(Double.parseDouble(material2.getText()));
        }

        if(materialAmount.getValue() == "3"){
            materials.add(Double.parseDouble(material1.getText()));
            materials.add(Double.parseDouble(material2.getText()));
            materials.add(Double.parseDouble(material3.getText()));
        }
        return materials;
    }

    private List<Double> getRequiredAmountValue(){
        List<Double> required = new ArrayList<>();
        if(requiredAmount.getValue() == "1"){
            required.add(Double.parseDouble(amount1.getText()));
        }

        if(requiredAmount.getValue() == "2"){
            required.add(Double.parseDouble(amount1.getText()));
            required.add(Double.parseDouble(amount2.getText()));
        }

        if(requiredAmount.getValue() == "3"){
            required.add(Double.parseDouble(amount1.getText()));
            required.add(Double.parseDouble(amount2.getText()));
            required.add(Double.parseDouble(amount3.getText()));
        }
        return required;
    }


    private List<Double> getWidthValue(){
        List<Double> widths = new ArrayList<>();
        if(widthAmount.getValue() == "1"){
            widths.add(Double.parseDouble(width1.getText()));
        }

        if(widthAmount.getValue() == "2"){
            widths.add(Double.parseDouble(width1.getText()));
            widths.add(Double.parseDouble(width2.getText()));
        }

        if(widthAmount.getValue() == "3"){
            widths.add(Double.parseDouble(width1.getText()));
            widths.add(Double.parseDouble(width2.getText()));
            widths.add(Double.parseDouble(width3.getText()));
        }
        return widths;
    }
}
