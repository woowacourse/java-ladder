package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final Ladder ladder;

    public LadderGame(List<String> playerNames, int lineMaxSize) {
        ladder = new Ladder(generateLines(playerNames.size(), lineMaxSize));
    }

    private List<Line> generateLines(int playerSize, int lineMaxSize) {
        List<Line> lines = new ArrayList<>();
        for (int lineIndex = 0; lineIndex < lineMaxSize; lineIndex++) {
            lines.add(new Line(playerSize - 1));
        }
        return lines;
    }

    public Ladder getLadder() {
        return ladder;
    }

}
