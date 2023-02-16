package ladder.domain;

import java.util.List;

public class Players {

    public static final int MIN_PLAYER_COUNT = 2;

    private final List<Player> players;

    public Players(List<Player> players) {
        validatePlayers(players);
        this.players = players;
    }

    private void validatePlayers(List<Player> players) {
        if (players.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("참가자는 1명이하일 수 없습니다.");
        }
    }
}
