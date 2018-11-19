package view.main;

import model.CuttingTableBuilder;
import model.CuttingTableColumn;
import model.OutputProductTypes;

import java.util.ArrayList;

public class ConsoleMain {

    public static void main(String[] args){
        ArrayList<Double> inputProductSpec = new ArrayList<>();
        inputProductSpec.add(2.1);
        inputProductSpec.add(4.2);
        ArrayList<Double> outputProductSpec = new ArrayList<>();
        outputProductSpec.add(0.5);
        outputProductSpec.add(1.4);

        ArrayList<Integer> outputProductAmount = new ArrayList<>();
        outputProductAmount.add(24000);
        outputProductAmount.add(12858);

        OutputProductTypes productTypes = new OutputProductTypes(outputProductSpec,outputProductAmount,outputProductSpec.size());
        CuttingTableBuilder cuttingTableBuilder = new CuttingTableBuilder();
        cuttingTableBuilder.buildTable(inputProductSpec,productTypes);

        for (CuttingTableColumn column: cuttingTableBuilder.cuttingTable) {
            System.out.print(column.getInputTableSpec()+"\t");
            for (int i = 0; i < column.getCuttingOptionsForOutputTableSpec().size(); i++){
                System.out.println(column.getCuttingOptionsForOutputTableSpec().toString() +"waste: "+column.getWaste());
            }
        }

    }
}
