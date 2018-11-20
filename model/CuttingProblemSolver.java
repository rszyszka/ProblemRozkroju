package model;

import javafx.scene.layout.ConstraintsBase;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CuttingProblemSolver {

    public static void solve(List<CuttingTableColumn> cuttingTable, OutputProductTypes outputProductTypes){
        List<Double> coefficients = new ArrayList<>();
        List<LinearConstraint> constraints = new ArrayList<>();
        int index = 0;
        System.out.println("\n");
        for (CuttingTableColumn column: cuttingTable) {
            coefficients.add(Math.round(column.getWaste()*100.0)/100.0);
            List<Double> constraintCoefficients = new ArrayList<>();
            for(OutputProduct outputProduct : outputProductTypes.getOutputProducts()){
                if(column.getCuttingOptionsForOutputTableSpec().containsKey(outputProduct.getWidth())) {
                    double amount = column.getCuttingOptionsForOutputTableSpec().get(outputProduct.getWidth());
                    constraintCoefficients.add(amount);
                }else{
                    constraintCoefficients.add(0.0);
                }
            }
            double[] constraintsCoefficientsTable = convertDoubles(constraintCoefficients);
            System.out.println(Arrays.toString(constraintsCoefficientsTable));
            LinearConstraint constraint = new LinearConstraint(constraintsCoefficientsTable,
                    Relationship.GEQ,
                    outputProductTypes.getOutputProducts().get(index).getRequiredAmount());
            constraints.add(constraint);
            index = (index+1) % outputProductTypes.getOutputProducts().size();
        }

        LinearObjectiveFunction objectiveFunction = new LinearObjectiveFunction(convertDoubles(coefficients),0);
        LinearConstraintSet constraintSet = new LinearConstraintSet(constraints);
        //System.out.println("\n");
        //System.out.println(constraints.toString());
        System.out.println(coefficients.toString());

        //SimplexSolver simplexSolver = new SimplexSolver();
        //PointValuePair pointValuePair = simplexSolver.optimize(objectiveFunction, constraintSet);
        //return pointValuePair.getPoint();
    }

    private static double[] convertDoubles(List<Double> integers)
    {
        double[] ret = new double[integers.size()];
        Iterator<Double> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = iterator.next();
        }
        return ret;
    }

}
