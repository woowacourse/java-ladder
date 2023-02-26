package ladder.domain.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final int MINIMUM_COUNT_OF_PLAYERS = 2;
    private static final String ALL_TARGET_PLAYERS = "all";

    private final List<Player> players;

    private Players(List<Player> players) {
        validateDuplicatedNames(players);

        this.players = new ArrayList<>(players);
    }

    public static Players create(List<String> playerNames) {
        validateContainsAll(playerNames);
        validateCountOfPlayers(playerNames);
        List<Player> players = playerNames.stream()
                .map(playerName -> new Player(new Name(playerName)))
                .collect(Collectors.toList());

        return new Players(players);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int count() {
        return players.size();
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    private static void validateContainsAll(List<String> playerNames) {
        if (playerNames.contains(ALL_TARGET_PLAYERS)) {
            throw new IllegalArgumentException("플레이어 이름으로 all은 금지됩니다.");
        }
    }

    private static void validateCountOfPlayers(List<String> inputPlayers) {
        if (inputPlayers.size() < MINIMUM_COUNT_OF_PLAYERS) {
            throw new IllegalArgumentException("플레이어의 수는 2명 이상이어야 합니다.");
        }
    }

    private void validateDuplicatedNames(List<Player> inputPlayers) {
        int playersWithoutDuplication = countPlayersWithoutDuplication(inputPlayers);

        if (playersWithoutDuplication != inputPlayers.size()) {
            throw new IllegalArgumentException("플레이어의 이름이 중복됩니다.");
        }
    }

    private int countPlayersWithoutDuplication(List<Player> inputPlayers) {
        return inputPlayers.stream()
                .map(Player::getName)
                .collect(Collectors.toSet())
                .size();
    }

}
