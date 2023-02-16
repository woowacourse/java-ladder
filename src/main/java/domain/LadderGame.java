package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;

    public LadderGame(List<String> playerNames, int ladderHeight) {
        ladder = new Ladder(generateLines(playerNames.size(), ladderHeight));
        players = new Players(generatePlayers(playerNames));
    }

    private List<Line> generateLines(int playerSize, int ladderHeight) {
        List<Line> lines = new ArrayList<>();
        for (int lineIndex = 0; lineIndex < ladderHeight; lineIndex++) {
            lines.add(new Line(playerSize - 1));
        }
        return lines;
    }

    private List<Player> generatePlayers(List<String> playerNames) {
        return playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<String> getPlayerNames() {
        return players.getPlayerNames();
    }
}
