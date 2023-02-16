package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    private final Players players;
    private final LadderHeight ladderHeight;

    public Ladder(Players players, LadderHeight ladderHeight) {
        this.players = players;
        this.ladderHeight = ladderHeight;
        makeLadderLines(players.size(), ladderHeight.getHeight());
    }

    public Line getLine(int index) {
        return lines.get(index);
    }

    private void makeLadderLines(int playerSize, int height) {
        IntStream.range(0, height).forEach(
                (index) -> lines.add(new Line(new RandomPointGenerator(), playerSize))
        );
    }
}
