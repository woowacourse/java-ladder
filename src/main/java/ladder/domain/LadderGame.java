package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private final List<PlayerName> players;
    private final Ladder ladder;

    public LadderGame(List<PlayerName> players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public List<String> playGame() {
        List<PlayerName> playerNames = new ArrayList<>(players);
        for (int i = 0; i < ladder.getHeight(); i++) {
            playerNames = playOneLine(playerNames, i);
        }
        return getResult(playerNames);
    }

    private List<PlayerName> playOneLine(List<PlayerName> playerNames, int height) {
        List<Line> lines = ladder.getLines();
        Line line = lines.get(height);

        Line lineAddGap = line.addGap();
        for (int i = 0; i < line.getSticks().size(); i++) {
            int movePosition = lineAddGap.move(i);
            Collections.swap(playerNames, i, movePosition);
        }
        return playerNames;
    }

    private List<String> getResult(List<PlayerName> players) {
        return players.stream()
                .map(PlayerName::getName)
                .collect(Collectors.toList());
    }
}
