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
                build2(outputProductTypes,inputProductWidth, 0.0, actualCounters, map, 0);

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
                          HashMap<Double,Integer> map
                            ,int depth){
        boolean checker = false;
        depth++;
        for(int i = 0; i <outputProductTypes.getSize(); i++){
            //i = i == outputProductTypes.getSize() ? i-1:i;
            double outputProductWidth = outputProductTypes.getOutputProducts().get(i).getWidth();
            System.out.println("Depth: "+depth+"\tProductWidth: "+outputProductWidth+"\tActualValue: "+actualValue+"\tChecker: "+checker);
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
            int[] clonedCounters = actualCounters.clone();
            clonedCounters[i]++;
            HashMap<Double,Integer> mapCopy = new HashMap<>(map);
            checker = build(outputProductTypes,inputProductWidth,actualValue,clonedCounters,mapCopy,depth);
        }
        return false;
    }

    private boolean build2(OutputProductTypes outputProductTypes,
                          double inputProductWidth,
                          double actualValue,
                          int[] actualCounters,
                          HashMap<Double,Integer> map
            ,int depth){
        if(actualValue > inputProductWidth){
            return true;
        }
        boolean el_added = false;
        depth++;
        for(int i = 0; i <outputProductTypes.getSize(); i++){
            double outputProductWidth = outputProductTypes.getOutputProducts().get(i).getWidth();
            int[] clonedCounters = actualCounters.clone();
            clonedCounters[i]++;
            HashMap<Double,Integer> mapCopy = new HashMap<>(map);
            boolean func_status = build2(outputProductTypes,inputProductWidth,actualValue +outputProductWidth,clonedCounters,mapCopy,depth);
            if(func_status) {
                if (!el_added) {
                    for (int j = 0; j < outputProductTypes.getSize(); j++)
                        map.put(outputProductTypes.getOutputProducts().get(j).getWidth(), actualCounters[j]);
                    cuttings.add(map);
                }
            }
            el_added = true;
        }
        return false;
    }

    public ArrayList<CuttingTableColumn> getCuttingTable() {
        return cuttingTable;
    }
}