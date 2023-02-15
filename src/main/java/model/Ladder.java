package model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> ladderLine = new ArrayList<>();
    private final LadderHeight height;

    public Ladder(int playerNumber,LadderHeight height){
        for(int index = 0; index<height.getLadderHeight(); index++) {
            this.ladderLine.add(new Line(playerNumber));
        }
        this.height = height;
    }
}
