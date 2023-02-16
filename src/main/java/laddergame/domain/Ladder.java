package laddergame.domain;

import laddergame.util.PointGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;
    private final LadderHeight ladderHeight;

    // pointGenerator를 어디에서 관리할 것인가 -> LadderGame vs Ladder
    // LadderGame관리 -> parameter 3개
    // Ladder -> pointGenerator 생성을 ladder에서 하는게 어색, ladder에서 RandomPointGenerator import 하는게 x
    public Ladder(int playerCount, int height, PointGenerator pointGenerator) {
        this.ladderHeight = new LadderHeight(height);
        this.lines = List.copyOf(generateLines(playerCount, pointGenerator));
    }

    private List<Line> generateLines(int playerCount, PointGenerator pointGenerator) {
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
