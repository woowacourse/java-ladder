package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(Players players, LadderHeight ladderHeight) {
        makeLadderLines(players.size(), ladderHeight.getHeight());
    }

    public Line getLine(int index) {
        return lines.get(index);
    }

    public int getHeight(){
        return lines.size();
    }

    private void makeLadderLines(int playersSize, int height) {
        IntStream.range(0, height).forEach(
                (index) -> lines.add(new Line(new RandomPointGenerator(), playersSize))
        );
    }
}
