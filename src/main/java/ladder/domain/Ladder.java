package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines = new ArrayList<>();

    public Ladder(int countOfPerson, int height) {
        for (int i = 0; i < height; ++i) {
            lines.add(new Line(countOfPerson));
        }
    }

    public Player goDownLadder(Player player) {
        for (Line line : lines) {
            line.getNextPositon(player);
        }
        return player;
    }

    @Override
    public String toString() {
        List<String> ladderElements = new ArrayList<>();

        for (Line line : lines) {
            ladderElements.add(line.toString());
        }
        return String.join("\n", ladderElements);
    }
}
