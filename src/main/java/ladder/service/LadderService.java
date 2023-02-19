package ladder.service;

import java.util.Arrays;
import java.util.stream.Collectors;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Line;
import java.util.ArrayList;
import java.util.List;
import ladder.domain.Player;
import ladder.domain.Players;

public class LadderService {
    private static final String PLAYERS_STRING_DELIMITER = ",";

    private final LineStrategy lineStrategy;

    public LadderService(LineStrategy lineStrategy) {
        this.lineStrategy = lineStrategy;
    }

    public Ladder createLadder(Height height, int playerCount) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(lineStrategy.generate(playerCount));
        }
        return new Ladder(lines, playerCount);
    }

    public Players createPlayers(String namesInput) {
        String[] playerNames = namesInput.split(PLAYERS_STRING_DELIMITER);
        List<Player> players = Arrays.stream(playerNames)
                .map(Player::new)
                .collect(Collectors.toList());
        return new Players(players);
    }
}
