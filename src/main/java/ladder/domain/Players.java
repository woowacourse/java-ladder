package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Players {

    public static final int MIN_PLAYER_COUNT = 2;

    private final List<Player> players;

    public Players(final List<Player> players) {
        validatePlayers(players);
        this.players = players;
    }

    private void validatePlayers(final List<Player> players) {
        if (players.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("참가자는 " + MIN_PLAYER_COUNT + "명 이상이어야 합니다.");
        }
    }

    public List<Player> toUnmodifiablePlayers() {
        return Collections.unmodifiableList(players);
    }

    public void moveAll(Line line) {
        for (final Player player : players) {
            int position = player.getPosition();
            Direction direction = line.decideDirection(position);
            player.move(direction);
        }
    }

    public int size() {
        return players.size();
    }

    public Player getPlayerByName(final String name) {
        return players.stream()
                .filter(player -> name.equals(player.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 참가자입니다"));

    }
}
