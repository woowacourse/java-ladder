package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    private final Players players;

    public Ladder(Players players, LadderHeight ladderHeight) {
        this.players = players;
        makeLadderLines(ladderHeight.getHeight());
    }

    public Line getLine(int index) {
        return lines.get(index);
    }

    public int size(){
        return players.size();
    }

    private void makeLadderLines(int height) {
        IntStream.range(0, height).forEach(
                (index) -> lines.add(new Line(new RandomPointGenerator(), players.size()))
        );
    }
}
