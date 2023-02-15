package model;

import util.Generator;
import util.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int MINIMUM_LINE_SIZE = 1;

    public Generator generator = new LineGenerator();
    private List<Boolean> points = new ArrayList<>();

    public Line (int personCount) {
        for(int column=0; column<personCount-1; column++) {
            points.add(generator.generate());
            if(validateLineMake(column)){
                column--;
            }
        }
    }

    private boolean validateLineMake(int column){
        if(points.size()>=MINIMUM_LINE_SIZE){
            if(validateContinuousLine(column) && validateTrueLine(column)){
                points.remove(column);
                return true;
            }
        }
        return false;
    }

    private boolean validateContinuousLine(int column){
        if(points.get(column) == points.get(column-1)){
            return true;
        }
        return false;
    }

    private boolean validateTrueLine(int index){
        if(points.get(index)==true){
            return true;
        }
        return false;
    }
}
