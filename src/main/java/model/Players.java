package model;

import exception.Message;
import java.util.List;
import java.util.Set;

public class Players {

    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 12;

    private final List<Player> playerNames;

    public Players(final List<String> playerNames) {
        validate(playerNames);
        this.playerNames = playerNames.stream()
                .map(Player::new)
                .toList();
    }

    private void validate(final List<String> players) {
        validateSize(players);
        validateDuplicates(players);
    }

    private void validateSize(final List<String> players) {
        if (players.size() < MIN_PLAYERS || players.size() > MAX_PLAYERS) {
            throw new IllegalArgumentException(Message.INVALID_PLAYER_ERROR.getValue());
        }
    }

    private void validateDuplicates(final List<String> players) {
        if (isDuplicated(players)) {
            throw new IllegalArgumentException(Message.INVALID_PLAYER_ERROR.getValue());
        }
    }

    private boolean isDuplicated(final List<String> players) {
        return Set.copyOf(players).size() != players.size();
    }

    public List<String> getNames() {
        return playerNames.stream()
                .map(Player::getName)
                .toList();
    }

    public int size() {
        return playerNames.size();
    }

    public String format() {
        return String.format("%s%s%s", formatFirstPlayer(), formatMiddlePlayer(), formatLastPlayer());
    }

    private String formatFirstPlayer() {
        return String.format("%s ", playerNames.get(0).getName());
    }

    private String formatMiddlePlayer() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Player player : playerNames.subList(1, playerNames.size() - 1)) {
            stringBuilder.append(String.format("%6s", player.getName()));
        }
        return stringBuilder.toString();
    }

    private String formatLastPlayer() {
        return String.format("%5s", playerNames.get(playerNames.size() - 1).getName());
    }

    public List<Player> getPlayerNames() {
        return playerNames;
    }
}
