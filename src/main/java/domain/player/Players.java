package domain.player;

import domain.player.message.PlayerExceptionMessage;
import java.util.List;

public class Players {
    public static final int PLAYER_NAMES_MIN_RANGE = 2;
    public static final int PLAYER_NAMES_MAX_RANGE = 10;

    private final List<Player> players;

    public Players(final List<Player> players) {
        validate(players);
        this.players = List.copyOf(players);
    }

    private void validate(final List<Player> players) {
        validateDuplication(players);
        validateRange(players);
    }

    private void validateRange(final List<Player> players) {
        if (players.size() < PLAYER_NAMES_MIN_RANGE || players.size() > PLAYER_NAMES_MAX_RANGE) {
            throw new IllegalArgumentException(PlayerExceptionMessage.PLAYER_NAMES_RANGE);
        }
    }

    private void validateDuplication(final List<Player> players) {
        int playerCount = players.size();
        long distinctCount = players.stream()
                .map(Player::getName)
                .distinct()
                .count();

        if (playerCount != distinctCount) {
            throw new IllegalArgumentException(PlayerExceptionMessage.PLAYER_NAMES_DUPLICATION);
        }
    }

    public void moveToPlayerOfIndex(final int index, final int direction) {
        players.get(index).moveTo(direction);
    }

    public int getPlayerCount() {
        return players.size();
    }

    public Player getPlayerOfIndex(int index) {
        return players.get(index);
    }

    public String getNameOfIndex(final int index) {
        return players.get(index).getName();
    }

    public int getPositionOfIndex(final int index) {
        return players.get(index).getPosition();
    }

    public boolean isParticipate(final String playerName) {
        return players.stream()
                .anyMatch(player -> player.getName().equals(playerName));
    }
}
