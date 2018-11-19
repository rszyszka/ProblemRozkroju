package model;

        import java.util.ArrayList;

public class CuttingTableBuilder {

    public ArrayList<CuttingTableColumn> cuttingTable;
    private boolean isCompleted;

    public CuttingTableBuilder(){
        cuttingTable = new ArrayList<>();
    }

    public void buildTable(ArrayList<Double> inputProductSpec, OutputProductTypes outputProductTypes){
        for (Double inputProductWidth : inputProductSpec) {
            for(int i = 0; i <outputProductTypes.getSize(); i++){
                isCompleted = false;
                CuttingTableColumn column = new CuttingTableColumn(inputProductWidth);
                double waste = build(outputProductTypes,inputProductWidth,i, column);
                column.setWaste(waste);
                cuttingTable.add(column);
            }
        }
    }

    private double build(OutputProductTypes outputProductTypes, double remainingInputProductWidth, int index, CuttingTableColumn column){
        int counter = 0;
        double outputProductWidth = outputProductTypes.getOutputProducts().get(index).getWidth();
        double tempRemainingProductWidth;

        while(true){
            tempRemainingProductWidth = remainingInputProductWidth;
            remainingInputProductWidth -= outputProductWidth;
            if(remainingInputProductWidth < 0.0){
                column.getCuttingOptionsForOutputTableSpec().put(outputProductWidth,counter);
                if(index - 1 < 0){
                    isCompleted = true;
                    return tempRemainingProductWidth;
                }
                index--;
                double returnedValue = build(outputProductTypes, tempRemainingProductWidth, index, column);
                if(isCompleted) {
                    return returnedValue;
                }

            }
            counter++;
        }
    }
}
