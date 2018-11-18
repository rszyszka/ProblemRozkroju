package model;

public class OutputProduct {

    private final int requiredAmount;
    private final double width;

    public OutputProduct(int requiredAmount, double width){
        this.requiredAmount = requiredAmount;
        this.width = width;
    }

    public int getRequiredAmount() {
        return requiredAmount;
    }

    public double getWidth() {
        return width;
    }
}
