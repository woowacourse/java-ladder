package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderGame {
    private final List<PlayerName> players;
    private final Ladder ladder;

    public LadderGame(List<PlayerName> players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    private List<PlayerName> playOneLine(List<PlayerName> playerNames, int height) {
        List<Line> lines = ladder.getLines();
        Line line = lines.get(height);

        Line line1 = line.addGap();
        for (int i = 0; i < line.getSticks().size(); i++) {
            int movePosition = line1.move(i);
            Collections.swap(playerNames, i, movePosition);
        }
        return playerNames;
    }

    public List<String> playGame() {
        List<PlayerName> playerNames = new ArrayList<>(players);
        for (int i = 0; i < ladder.getHeight(); i++) {
            playerNames = playOneLine(playerNames, i);
        }
        return getResult(playerNames);
    }

    private static List<String> getResult(List<PlayerName> playerNames) {
        List<String> playerNames2 = new ArrayList<>();
        for (PlayerName player : playerNames) {
            playerNames2.add(player.getName());
        }
        return playerNames2;
    }
}
