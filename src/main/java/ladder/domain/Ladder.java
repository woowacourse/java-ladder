package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines = new ArrayList<>();

    public Ladder(int numPlayers, int height) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(makePoints(numPlayers)));
        }
    }

    public List<Boolean> makePoints(int numPlayers) {
        List<Boolean> points = new ArrayList<>();
        points.add(randomBoolean());

        while (points.size() < numPlayers - 1) {
            points.add(validRandom(points.get(points.size() - 1)));
        }

        return points;
    }

    private boolean validRandom(boolean prev) {
        if (prev) {
            return false;
        }
        return randomBoolean();
    }

    private boolean randomBoolean() {
        return (int) (Math.random() * 2) > 0;
    }

    public List<Player> goDown(List<Player> players) {
        return goDown(lines, players);
    }

    public static List<Player> goDown(List<Line> lines, List<Player> players) {
        for (Line line : lines) {
            goDownOneLine(players, line);
        }
        return players;
    }

    private static void goDownOneLine(List<Player> players, Line line) {
        for (Player player : players) {
            player.goDown(line);
        }
    }

    public List<Line> getLines() {
        return lines;
    }

}
