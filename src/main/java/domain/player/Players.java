package domain.player;

import exception.CountException;
import exception.DuplicateException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {
    private final List<Player> players;

    private static final int PLAYER_MIN_COUNT = 2;
    private static final int PLAYER_MAX_COUNT = 12;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players generate(List<String> playersName) {
        checkPlayers(playersName);
        List<Player> players = new ArrayList<>();
        for (int index = 0; index < playersName.size(); index++) {
            players.add(new Player(playersName.get(index), index));
        }
        return new Players(List.copyOf(players));
    }

    public int getMaxPlayerNameLength() {
        return players.stream()
                .mapToInt(player -> player.getPlayerName().length())
                .max()
                .orElseThrow();
    }

    public int getPlayersCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    private static void checkPlayers(List<String> playerNames) {
        checkPlayerCount(playerNames);
        checkDuplicatePlayers(playerNames);
    }

    private static void checkPlayerCount(List<String> players) {
        if (players.size() < PLAYER_MIN_COUNT || players.size() > PLAYER_MAX_COUNT) {
            throw new CountException();
        }
    }

    private static void checkDuplicatePlayers(List<String> players) {
        if (players.stream().distinct().count() != players.size()) {
            throw new DuplicateException();
        }
    }
}
