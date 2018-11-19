package model;

import java.util.ArrayList;
import java.util.TreeSet;

public class OutputProductTypes {

    private final int size;
    private final ArrayList<OutputProduct> outputProducts;

    public OutputProductTypes(ArrayList<Double> widths, ArrayList<Integer> amountsOfPieces, int size){
        this.size = size;
        TreeSet<OutputProduct> sortedOutputProducts = new TreeSet<>(new ProductComparator());
        for(int i = 0; i < size; i++){
            sortedOutputProducts.add(new OutputProduct(amountsOfPieces.get(i),widths.get(i)));
        }
        outputProducts = new ArrayList<>(sortedOutputProducts);
    }

    public int getSize() {
        return size;
    }

    public ArrayList<OutputProduct> getOutputProducts() {
        return outputProducts;
    }
}
