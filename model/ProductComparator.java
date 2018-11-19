package model;

import java.util.Comparator;

public class ProductComparator implements Comparator<OutputProduct> {

    @Override
    public int compare(OutputProduct o1, OutputProduct o2) {
        return Double.compare(o1.getWidth(), o2.getWidth());
    }
}
