package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

    private static final int MINIMUM_LENGTH_OF_PLAYER = 2;
    private static final int MAXIMUM_LENGTH_OF_PLAYER = 10;

    private final List<Player> players;

    public Players(final List<String> playerNames) {
        validateNumberOfPlayers(playerNames);
        validateDuplicatedPlayers(playerNames);
        this.players = makePlayers(playerNames);
    }

    private void validateNumberOfPlayers(final List<String> playerNames) {
        if (isNotPermittedNumberOfPlayers(playerNames)) {
            throw new IllegalArgumentException("참여 가능한 플레이어의 수는 2명이상 10명이하 입니다.");
        }
    }

    private boolean isNotPermittedNumberOfPlayers(List<String> playerNames) {
        return (playerNames.size() < MINIMUM_LENGTH_OF_PLAYER) || (playerNames.size() > MAXIMUM_LENGTH_OF_PLAYER);
    }

    private void validateDuplicatedPlayers(final List<String> playerNames) {
        Set<String> nameWithoutDuplicated = new HashSet<>(playerNames);

        if (playerNames.size() != nameWithoutDuplicated.size()) {
            throw new IllegalArgumentException("참가한 플레이어의 이름 중 중복된 이름이 존재하면 안됩니다.");
        }
    }

    private List<Player> makePlayers(final List<String> playerNames) {
        return playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public int findLongestPlayerName() {
        return players.stream()
                .mapToInt(player -> player.getName().length())
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int findNumberOfPlayers() {
        return this.players.size();
    }

    public Player findFirstPlayer() {
        return this.players.get(0);
    }

    public int findLengthOfFirstPlayerName() {
        return this.players.get(0).getLengthOfPlayerName();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
