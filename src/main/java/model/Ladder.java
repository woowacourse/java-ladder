package model;

import util.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> ladderLine = new ArrayList<>();

    public Ladder(Names names,LadderHeight height){
        for(int index = 0; index<height.getLadderHeight(); index++) {
            this.ladderLine.add(new Line(names.getNames().size(),new LineGenerator()));
        }
    }

    public boolean getLadderLine(int row, int column){
            return ladderLine.get(row).getLine(column);
    }
}
