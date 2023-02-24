package domain.player;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Players {

    private static final String NOT_EXIST_PLAYER_NAME_ERROR_MESSAGE = "존재하지 않는 참여자 입니다.";

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players from(PlayerNames playerNames) {
        return new Players(playerNames.getPlayerNames()
                .stream()
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public int playerAmount() {
        return this.players.size();
    }

    public Player findByName(String playerName) {
        return this.players.stream()
                .filter(player -> player.getPlayerName().equals(playerName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(NOT_EXIST_PLAYER_NAME_ERROR_MESSAGE));
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }

}
