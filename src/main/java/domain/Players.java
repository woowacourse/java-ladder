package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    public static final String PLAYERS_SIZE_ERROR_MESSAGE = "[ERROR] 사다리 게임을 위해서는 2명 이상의 플레이어가 필요합니다";
    public static final int MIN_PLAYERS_SIZE = 2;

    private List<Player> players;

    public Players(PlayerNames playerNames) {
        players = new ArrayList<>();
        validatePlayersSize(playerNames);
        createPlayers(playerNames);
    }

    private void validatePlayersSize(PlayerNames playerNames) {
        if (playerNames.getPlayerNames().size() < MIN_PLAYERS_SIZE) {
            throw new IllegalArgumentException(PLAYERS_SIZE_ERROR_MESSAGE);
        }
    }

    private void createPlayers(PlayerNames playerNames) {
        for(PlayerName playerName :playerNames.getPlayerNames()) {
            this.players.add(new Player(playerName.getName()));
        }
    }

    public List<String> getPlayersName() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public int getPlayersSize() {
        return players.size();
    }
}
