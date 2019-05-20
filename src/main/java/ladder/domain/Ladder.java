package ladder.domain;

import ladder.utils.PointsGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines = new ArrayList<>();
    private final PointsGenerator generator;

    public Ladder(final int numPlayers, final int height) {
        generator = new PointsGenerator(numPlayers);
        for (int i = 0; i < height; i++) {
            lines.add(new Line(generator.generate()));
        }
    }

    public List<Player> goDown(List<Player> players) {
        return goDown(lines, players);
    }

    static List<Player> goDown(final List<Line> lines, final List<Player> players) {
        for (Line line : lines) {
            goDownOneLine(players, line);
        }
        return players;
    }

    private static void goDownOneLine(final List<Player> players, final Line line) {
        for (Player player : players) {
            player.goDown(line);
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
