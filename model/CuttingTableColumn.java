package model;

import java.util.HashMap;

public class CuttingTableColumn {

    private double inputTableSpec;
    private double waste;
    private HashMap<Double,Integer> cuttingOptionsForOutputTableSpec;

    public CuttingTableColumn(HashMap<Double,Integer> map, double inputTableSpec, double waste){
        this.inputTableSpec = inputTableSpec;
        cuttingOptionsForOutputTableSpec = new HashMap<>(map);
        this.waste = waste;
    }

    public double getInputTableSpec() {
        return inputTableSpec;
    }

    public HashMap<Double, Integer> getCuttingOptionsForOutputTableSpec() {
        return cuttingOptionsForOutputTableSpec;
    }

    public double getWaste() {
        return waste;
    }
}