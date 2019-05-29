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
            line.move(players);
        }
    }
}
