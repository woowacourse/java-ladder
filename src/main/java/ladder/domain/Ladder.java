package ladder.domain;

import java.util.List;

public class Ladder {
    private List<Line> lines;

    public Ladder(int numPlayers, int height) {
        
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

}
