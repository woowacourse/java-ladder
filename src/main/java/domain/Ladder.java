package domain;

import util.LineItemGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(Height height, int playerCount, LineItemGenerator lineItemGenerator) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            Line line = new Line(playerCount, lineItemGenerator);
            ladder.add(line);
        }
        return new Ladder(ladder);
    }

    public int playLadderGame(int position) {
        for (Line line : ladder) {
            position = line.move(position);
        }
        return position;
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
