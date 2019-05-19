package ladder.domain;

import java.util.List;

public class LadderGame {
    private List<Player> players;
    private List<Line> ladder;

    public LadderGame(List<Player> players, List<Line> ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public void runGame() {
        for (Line line : ladder) {
            updateAllPlayerPosition(line);
        }
    }

    private void updateAllPlayerPosition(Line line) {
        for (Player player : players) {
            player.updatePosition(getNextPosition(line, player));
        }
    }

    private int getNextPosition(Line line, Player player) {
        return line.getLine().get(player.getPosition()).move();
    }
}
