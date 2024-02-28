package ladder.domain;

import java.util.List;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;

    public LadderGame(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public void playOneLine(int height) {
        List<Line> lines = ladder.getLines();
        Line line = lines.get(height);

        Line line1 = line.addGap();
        for (int i = 0; i < line.getSticks().size(); i = i + 2) {
            int movePosition = line1.move(i);
            players.changePosition(i, movePosition);
        }
    }

    public List<String> getPlayerResult() {
        return players.getPlayerNames();
    }
}
