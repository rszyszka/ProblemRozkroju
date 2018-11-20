package controller;

import com.jakewharton.fliptables.FlipTable;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.CuttingTableBuilder;
import model.CuttingTableColumn;
import model.OutputProductTypes;

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
    TextField width1;

    @FXML
    TextField width2;

    @FXML
    TextField width3;

    @FXML
    TextArea textArea;


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

        materialAmount.setValue("2");
        requiredAmount.setValue("2");

        material3.setVisible(false);
        amount3.setVisible(false);
        width3.setVisible(false);

        material1.setText("2.1");
        material2.setText("4.2");

        amount1.setText("24000");
        amount2.setText("12858");

        width1.setText("0.5");
        width2.setText("1.4");

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

                    width1.setVisible(true);
                    width2.setVisible(false);
                    width3.setVisible(false);
                    break;
                case "2":
                    amount1.setVisible(true);
                    amount2.setVisible(true);
                    amount3.setVisible(false);

                    width1.setVisible(true);
                    width2.setVisible(true);
                    width3.setVisible(false);
                    break;

                case "3":
                    amount1.setVisible(true);
                    amount2.setVisible(true);
                    amount3.setVisible(true);

                    width1.setVisible(true);
                    width2.setVisible(true);
                    width3.setVisible(true);
                    break;
            }
        });
    }

    @FXML
    public void findSolutionAction(){

        ArrayList<Double> inputProductSpec = getMaterialValue();

        ArrayList<Double> outputProductSpec = getWidthValue();

        ArrayList<Integer> outputProductAmount = getRequiredAmountValue();

        OutputProductTypes productTypes = new OutputProductTypes(outputProductSpec,outputProductAmount,outputProductSpec.size());
        CuttingTableBuilder cuttingTableBuilder = new CuttingTableBuilder();
        cuttingTableBuilder.buildTable(inputProductSpec,productTypes);

        textArea.clear();

        textArea.appendText("\t\t\tPROBLEM ROZKROJU\n\n");

        int k = 1;

        for (CuttingTableColumn column: cuttingTableBuilder.cuttingTable) {
                textArea.appendText("ID ROZKROJU: " + k++ + "\n\n");

                textArea.appendText("WYMIAR MATERIAŁU:\t\t\t" + column.getInputTableSpec() + "\n");

                textArea.appendText("MOŻLIWOŚĆ ROZKROJU:\t " + column.getCuttingOptionsForOutputTableSpec().toString() + "\n");

                textArea.appendText("STRATY: " + Math.round(column.getWaste()*100.0)/100.0 + "\n\n");
        }
    }
    
    private ArrayList<Double> getMaterialValue(){
        ArrayList<Double> materials = new ArrayList<>();
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

    private ArrayList<Integer> getRequiredAmountValue(){
        ArrayList<Integer> required = new ArrayList<>();
        if(requiredAmount.getValue() == "1"){
            required.add((int)Double.parseDouble(amount1.getText()));
        }

        if(requiredAmount.getValue() == "2"){
            required.add((int)Double.parseDouble(amount1.getText()));
            required.add((int)Double.parseDouble(amount2.getText()));
        }

        if(requiredAmount.getValue() == "3"){
            required.add((int)Double.parseDouble(amount1.getText()));
            required.add((int)Double.parseDouble(amount2.getText()));
            required.add((int)Double.parseDouble(amount3.getText()));
        }
        return required;
    }

    private ArrayList<Double> getWidthValue(){
        ArrayList<Double> widths = new ArrayList<>();
        if(requiredAmount.getValue() == "1"){
            widths.add(Double.parseDouble(width1.getText()));
        }

        if(requiredAmount.getValue() == "2"){
            widths.add(Double.parseDouble(width1.getText()));
            widths.add(Double.parseDouble(width2.getText()));
        }

        if(requiredAmount.getValue() == "3"){
            widths.add(Double.parseDouble(width1.getText()));
            widths.add(Double.parseDouble(width2.getText()));
            widths.add(Double.parseDouble(width3.getText()));
        }
        return widths;
    }
}
