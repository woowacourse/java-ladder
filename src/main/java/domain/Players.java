package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    public static final String PLAYERS_SIZE_ERROR_MESSAGE = "[ERROR] 사다리 게임을 위해서는 2명 이상의 플레이어가 필요합니다";
    public static final int PLAYERS_MIN_SIZE = 2;
    private List<Player> players;

    public Players(List<Player> players) {
        //TODO: 적어도 2명이 필요함(1명이면 사다리 탈 이유가 없지 않나?)
        this.players = validatePlayersSize(players);
    }

    private List<Player> validatePlayersSize(List<Player> players) {
        if (players.size() < PLAYERS_MIN_SIZE) {
            throw new IllegalArgumentException(PLAYERS_SIZE_ERROR_MESSAGE);
        }

        return players;
    }

    public List<String> getPlayersName() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }
}
