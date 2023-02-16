package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private List<Player> players;
    private Ladder ladder;

    public LadderGame(final BooleanGenerator booleanGenerator, final List<String> names, final int height) {
        this.players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
        this.ladder = new Ladder(booleanGenerator, height, players.size() - 1);
    }

    public List<String> getPlayers() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Line> getLadder() {
        return this.ladder.getLines();
    }
}
