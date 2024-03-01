package domain.player;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;

public class Players {
    private static final int MINIMUM_NUMBER_OF_PLAYERS = 2;
    private static final int MAXIMUM_NUMBER_OF_PLAYERS = 50;
    private static final String DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 중복된 이름이 존재합니다.";
    private static final String INVALID_PLAYER_COUNT_EXCEPTION_MESSAGE = "[ERROR] 참가자는 %d ~ %d명이어야 합니다.";

    private final List<Player> players;

    private Players(List<Player> players) {
        validateNumberOfPlayers(players);
        validateDuplicateName(players);
        this.players = players;
    }

    public static Players from(List<String> playerNames) { // todo validation 먼저
        return playerNames.stream()
                .map(Player::new)
                .collect(collectingAndThen(toList(), Players::new));
    }

    private void validateNumberOfPlayers(List<Player> players) {
        if (players.size() < MINIMUM_NUMBER_OF_PLAYERS || players.size() > MAXIMUM_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException(
                    String.format(INVALID_PLAYER_COUNT_EXCEPTION_MESSAGE, MINIMUM_NUMBER_OF_PLAYERS,
                            MAXIMUM_NUMBER_OF_PLAYERS)
            );
        }
    }

    private void validateDuplicateName(List<Player> players) {
        if (getUniqueNameCount(players) != players.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private long getUniqueNameCount(List<Player> players) {
        return players.stream()
                .distinct()
                .count();
    }

    public int findMaxNameLength() {
        return players.stream()
                .mapToInt(Player::getNameLength)
                .max()
                .orElse(0);
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .toList();
    }

    public int count() {
        return players.size();
    }

    public Player get(int index) { // todo 메서드명, index validation
        return players.get(index);
    }
}
