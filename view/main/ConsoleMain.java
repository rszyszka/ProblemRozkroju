package view.main;

import model.CuttingProblemSolver;
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
        for (CuttingTableColumn col : cuttingTableBuilder.getCuttingTable()) {
            System.out.println(col.getCuttingOptionsForOutputTableSpec());
        }
        /*double [] result = CuttingProblemSolver.solve(cuttingTableBuilder.cuttingTable, productTypes);
        CuttingProblemSolver.solve(cuttingTableBuilder.cuttingTable, productTypes);
        System.out.println("\n" + Arrays.toString(result));*/
    }
}
