package domain.player;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;

public class Players {
    private static final int MINIMUM_NUMBER_OF_PLAYERS = 2;
    private static final int MAXIMUM_NUMBER_OF_PLAYERS = 50;
    private static final int UNIQUE_COUNT = 1;

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players from(List<String> playerNames) {
        validateNumberOfPlayers(playerNames);
        validateDuplicateName(playerNames);
        return playerNames.stream()
                .map(Player::new)
                .collect(collectingAndThen(toList(), Players::new));
    }

    private static void validateNumberOfPlayers(List<String> playerNames) {
        if (playerNames.size() < MINIMUM_NUMBER_OF_PLAYERS || MAXIMUM_NUMBER_OF_PLAYERS < playerNames.size()) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] rejected value: %s - 참가자는 %d ~ %d명이어야 합니다.",
                            playerNames, MINIMUM_NUMBER_OF_PLAYERS, MAXIMUM_NUMBER_OF_PLAYERS)
            );
        }
    }

    private static void validateDuplicateName(List<String> playerNames) {
        Map<String, Long> nameCounts = getNameCounts(playerNames);

        nameCounts.entrySet().stream()
                .filter(entry -> entry.getValue() > UNIQUE_COUNT)
                .findFirst()
                .ifPresent(entry -> {
                    throw new IllegalArgumentException(
                            String.format("[ERROR] rejected value: %s - 중복된 참가자명이 존재합니다.", entry.getKey())
                    );
                });
    }

    private static Map<String, Long> getNameCounts(List<String> playerNames) {
        return playerNames.stream()
                .collect(groupingBy(name -> name, counting()));
    }

    public int findMaxPlayerNameLength() {
        return players.stream()
                .mapToInt(Player::getNameLength)
                .max()
                .orElse(0);
    }

    public Player findPlayerByIndex(int index) {
        if (isOutOfRange(index)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] rejected value: %d - index가 범위를 벗어났습니다.", index)
            );
        }
        return players.get(index);
    }

    private boolean isOutOfRange(int index) {
        return index < 0 || index >= players.size();
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .toList();
    }

    public int count() {
        return players.size();
    }
}
