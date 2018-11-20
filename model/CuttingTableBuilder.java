package model;

import java.util.*;

public class CuttingTableBuilder {

    private HashSet<HashMap<Double,Integer>> cuttings;
    private ArrayList<CuttingTableColumn> cuttingTable;

    public CuttingTableBuilder(){
        cuttingTable = new ArrayList<>();
    }

    public void buildTable(ArrayList<Double> inputProductSpec, OutputProductTypes outputProductTypes){
        for (Double inputProductWidth : inputProductSpec) {
                cuttings = new HashSet<>();
                HashMap<Double,Integer> map = new HashMap<>();
                int[] actualCounters = new int[outputProductTypes.getOutputProducts().size()];
                build(outputProductTypes,inputProductWidth, 0.0, actualCounters, map);

            for(HashMap<Double,Integer> m : cuttings){
                double sum = 0.0;
                for(Map.Entry<Double, Integer> entry : m.entrySet()){
                    sum += entry.getKey()*entry.getValue();
                }
                double waste = inputProductWidth - sum;
                cuttingTable.add(new CuttingTableColumn(m,inputProductWidth,waste));
            }
        }
    }

    private boolean build(OutputProductTypes outputProductTypes,
                          double inputProductWidth,
                          double actualValue,
                          int[] actualCounters,
                          HashMap<Double,Integer> map){
        boolean checker = false;
        for(int i = 0; i <outputProductTypes.getSize(); i++){
            double outputProductWidth = outputProductTypes.getOutputProducts().get(i).getWidth();
            actualValue += outputProductWidth;
            if(actualValue > inputProductWidth){
                if(checker){
                    return true;
                }
                for(int j = 0; j <outputProductTypes.getSize(); j++)
                    map.put(outputProductTypes.getOutputProducts().get(j).getWidth(), actualCounters[j]);
                cuttings.add(map);
                return true;
            }
            actualCounters[i]++;
            HashMap<Double,Integer> mapCopy = new HashMap<>(map);
            checker = build(outputProductTypes,inputProductWidth,actualValue,actualCounters.clone(),mapCopy);
        }
        return checker;
    }

    public ArrayList<CuttingTableColumn> getCuttingTable() {
        return cuttingTable;
    }
}