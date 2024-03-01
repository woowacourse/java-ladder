package domain.player;

import domain.ColumnPosition;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Players {

    private static final int MIN_COUNT = 2;

    private final List<Player> players;

    public Players(List<Player> players) {
        validate(players);
        this.players = players;
    }

    public ColumnPosition columnPositionOf(PlayerName playerName) {
        return players.stream()
                .filter(player -> player.getPlayerName().equals(playerName))
                .map(Player::getColumnPosition)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("[ERROR] 해당하는 이름의 참여자가 존재하지 않습니다"));
    }

    public int getPlayerCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return List.copyOf(players);
    }

    private void validate(List<Player> players) {
        validateEachNameUnique(players);
        validatePlayerCount(players);
    }

    private void validateEachNameUnique(List<Player> players) {
        if (players.size() != countUniqueNamePlayer(players)) {
            throw new IllegalArgumentException("[ERROR] 이름이 중복되는 참가자가 있습니다");
        }
    }

    private int countUniqueNamePlayer(List<Player> players) {
        return players.stream()
                .map(Player::getPlayerName)
                .collect(Collectors.toSet()).size();
    }

    private void validatePlayerCount(List<Player> players) {
        if (players.size() < MIN_COUNT) {
            throw new IllegalArgumentException("[ERROR] 참여 인원은 " + MIN_COUNT + "명 이상이어야 합니다");
        }
    }
}
