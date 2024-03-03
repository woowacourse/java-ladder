package laddergame.domain.gameelements;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private static final int MIN_PLAYER_NUMBER = 1;
    private static final int MAX_PLAYER_NUMBER = 100;

    private final List<Player> players;

    public Players(List<String> players) {
        validatePlayerNumber(players);

        this.players = new ArrayList<>();

        for (int i = 0; i < players.size(); i++) {
            Name playerName = new Name(players.get(i));
            Position position = new Position(i);
            this.players.add(new Player(playerName, position));
        }
    }

    public int count() {
        return players.size();
    }

    private void validatePlayerNumber(List<String> playerNames) {
        if (playerNames.size() < MIN_PLAYER_NUMBER || playerNames.size() > MAX_PLAYER_NUMBER) {
            throw new IllegalArgumentException("게임 참여자의 수는 1이상 100이하만 가능합니다.");
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
