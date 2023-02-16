package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final int MINIMUM_COUNT_OF_PLAYERS = 2;
    private final List<Player> players;

    public Players(List<Player> players) {
        validateDuplicatedNames(players);
        validateCountOfPlayers(players);

        this.players = new ArrayList<>(players);
    }

    public int count() {
        return players.size();
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
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

    private void validateCountOfPlayers(List<Player> inputPlayers) {
        if (inputPlayers.size() < MINIMUM_COUNT_OF_PLAYERS) {
            throw new IllegalArgumentException("플레이어의 수는 2명 이상이어야 합니다.");
        }
    }

}
