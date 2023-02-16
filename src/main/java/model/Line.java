package model;

import util.Generator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int MINIMUM_LINE_SIZE = 2;

    private final List<Boolean> points = new ArrayList<>();

    public Line (int personCount,Generator generator) {
        for(int column=0; column<personCount-1; column++) {
            points.add(generator.generate());
            if(validateLineMake(column)){
                column--;
            }
        }
    }

    private boolean validateLineMake(int column){
        if(points.size()>=MINIMUM_LINE_SIZE){
            if(validateConnectLine(column) && validateTrueLine(column)){
                points.remove(column);
                return true;
            }
        }
        return false;
    }

    private boolean validateConnectLine(int column){
        return points.get(column).equals(points.get(column-1));
    }

    private boolean validateTrueLine(int index){
        return points.get(index);
    }

    public boolean getLine(int column){
        return points.get(column);
    }
}
