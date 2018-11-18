package model;

import java.util.ArrayList;
import java.util.HashMap;

public class CuttingTableColumn {

    private double inputTableSpec;
    private HashMap<Double,Integer> cuttingOptionsForOutputTableSpec;

    public CuttingTableColumn(double inputTableSpec){
        this.inputTableSpec = inputTableSpec;
        cuttingOptionsForOutputTableSpec = new HashMap<>();
    }

    public double getInputTableSpec() {
        return inputTableSpec;
    }

    public HashMap<Double, Integer> getCuttingOptionsForOutputTableSpec() {
        return cuttingOptionsForOutputTableSpec;
    }
}
