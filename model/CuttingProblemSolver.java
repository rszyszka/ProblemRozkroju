package model;

import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.*;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import java.util.*;

public class CuttingProblemSolver {

    public static double[] solve(List<CuttingTableColumn> cuttingTable, OutputProductTypes outputProductTypes){
        List<Double> coefficients = new ArrayList<>();
        List<LinearConstraint> constraints = new ArrayList<>();

        for(OutputProduct outputProduct :outputProductTypes.getOutputProducts()){
            List<Double> constraintCoefficients = new ArrayList<>();
            for (CuttingTableColumn column: cuttingTable) {
               double amount = column.getCuttingOptionsForOutputTableSpec().get(outputProduct.getWidth());
               constraintCoefficients.add(amount);
            }
            double[] constraintsCoefficientsTable = convertDoubles(constraintCoefficients);
            LinearConstraint constraint = new LinearConstraint(constraintsCoefficientsTable,
                    Relationship.GEQ,
                    outputProduct.getRequiredAmount());
            constraints.add(constraint);
        }

        for (CuttingTableColumn column: cuttingTable) {
            coefficients.add(Math.round(column.getWaste()*100.0)/100.0);
        }

        LinearObjectiveFunction objectiveFunction = new LinearObjectiveFunction(convertDoubles(coefficients),0);
        LinearConstraintSet constraintSet = new LinearConstraintSet(constraints);

        SimplexSolver simplexSolver = new SimplexSolver();
        PointValuePair pointValuePair = simplexSolver.optimize(objectiveFunction, constraintSet, GoalType.MINIMIZE, new NonNegativeConstraint(true));
        return pointValuePair.getPoint();
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
