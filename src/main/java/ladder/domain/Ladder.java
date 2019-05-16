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

    public List<Line> getLines() {
        return this.lines;
    }

    public Player getLastPosition(Player player) {
        for (Line line : lines) {
            line.getNextPositon(player);
        }
        return player;
    }
}
