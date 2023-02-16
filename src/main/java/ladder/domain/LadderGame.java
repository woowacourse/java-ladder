package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final Players players;

    public LadderGame(List<String> names) {
        List<Player> players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());

        this.players = new Players(players);
    }

    public List<Line> play(int height) {
        Lines lines = new Lines(players.size(), height);
        return lines.toUnModifiableLines();
    }

    public List<String> getPlayerNames() {
        return players.getNames();
    }
}
