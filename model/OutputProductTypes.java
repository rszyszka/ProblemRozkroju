package model;

import java.util.ArrayList;

public class OutputProductTypes {

    private final int size;
    private final ArrayList<OutputProduct> outputProducts;

    public OutputProductTypes(ArrayList<Double> widths, ArrayList<Integer> amountsOfPieces, int size){
        this.size = size;
        outputProducts = new ArrayList<>();
        for(int i = 0; i < size; i++){
            outputProducts.add(new OutputProduct(amountsOfPieces.get(i),widths.get(i)));
        }
    }

    public int getSize() {
        return size;
    }

    public ArrayList<OutputProduct> getOutputProducts() {
        return outputProducts;
    }
}
