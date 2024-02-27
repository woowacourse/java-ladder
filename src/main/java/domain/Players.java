package domain;

import java.util.List;

import static message.ErrorMessage.INVALID_PLAYER_COUNT_EXCEPTION;

public class Players {

    private static final int MINIMUM_PLAYER_COUNT = 2;
    private final List<Player> players;

    public Players(List<Player> players) {
        validatePlayerSize(players);
        this.players = players;
    }

    private static void validatePlayerSize(List<Player> players) {
        if (players.size() < MINIMUM_PLAYER_COUNT) {
            throw new IllegalArgumentException(INVALID_PLAYER_COUNT_EXCEPTION.getMessageWithCause(players.size()));
        }
    }

    public Player findByName(String name) {
        return players.stream()
                .filter(player -> player.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 플레이어 이름입니다."));
    }

    public int getWidth() {
        return players.size() - 1;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
