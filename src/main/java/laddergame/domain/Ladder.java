package laddergame.domain;

import laddergame.util.PointGenerator;
import laddergame.util.RandomPointGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    // todo: pointGenerator를 어디에서 관리할 것인가 -> LadderGame vs Ladder
    public Ladder(int playerCount, int height) {
        this.lines = List.copyOf(generateLines(playerCount, new LadderHeight(height)));
    }

    private List<Line> generateLines(int playerCount, LadderHeight ladderHeight) {
        PointGenerator pointGenerator = new RandomPointGenerator();
        List<Line> lines = new ArrayList<>();
        while (!ladderHeight.isMaxHeight(lines.size())) {
            lines.add(new Line(playerCount, pointGenerator));
        }
        return lines;
    }

    public List<Line> getLadder() {
        return lines;
    }
}
