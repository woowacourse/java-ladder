package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

import laddergame.domain.strategy.LineBuildStrategy;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder buildOf(final LineBuildStrategy lineBuildStrategy,
                                 final Players players,
                                 final Height height)
    {
        List<Line> temp = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            temp.add(Line.buildOf(lineBuildStrategy, players.getPlayersCount() - 1));
        }
        return new Ladder(temp);
    }

    public List<Line> getLines() {
        return lines;
    }
}
