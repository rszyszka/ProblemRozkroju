package view.main;

import model.CuttingProblemSolver;
import model.CuttingTableBuilder;
import model.CuttingTableColumn;
import model.OutputProductTypes;

import java.util.ArrayList;
import java.util.Arrays;

public class ConsoleMain {

    public static void main(String[] args){
        ArrayList<Double> inputProductSpec = new ArrayList<>();
        //inputProductSpec.add(2.1);
        //inputProductSpec.add(4.2);
        inputProductSpec.add(4.4);

        ArrayList<Double> outputProductSpec = new ArrayList<>();
        //outputProductSpec.add(0.5);
        //outputProductSpec.add(1.4);
        outputProductSpec.add(0.8);
        outputProductSpec.add(1.1);

        ArrayList<Integer> outputProductAmount = new ArrayList<>();
        //outputProductAmount.add(24000);
        //outputProductAmount.add(12858);
        outputProductAmount.add(400);
        outputProductAmount.add(1200);

        OutputProductTypes productTypes = new OutputProductTypes(outputProductSpec,outputProductAmount,outputProductSpec.size());
        CuttingTableBuilder cuttingTableBuilder = new CuttingTableBuilder();
        cuttingTableBuilder.buildTable(inputProductSpec,productTypes);
        for (CuttingTableColumn col : cuttingTableBuilder.getCuttingTable()) {
            System.out.println(col.getCuttingOptionsForOutputTableSpec());
        }
       double[] result = CuttingProblemSolver.solve(cuttingTableBuilder.getCuttingTable(), productTypes);
       System.out.println("\n" + Arrays.toString(result));
    }
}
