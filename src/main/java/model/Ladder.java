package model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> ladderLine = new ArrayList<>();

    public Ladder(int playerNumber,int height){
        for(int index = 0; index<height; index++) {
            this.ladderLine.add(new Line(playerNumber));
        }
    }

    public boolean getLadderLine(int row, int column){
        return ladderLine.get(row).getLine(column);
    }
}
