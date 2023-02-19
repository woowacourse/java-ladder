package ladder.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

    private static final int MINIMUM_COUNT_OF_PLAYERS = 2;
    private List<Player> players;

    public Players(List<String> playerNames) {
        validateDuplicatedNames(playerNames);
        validateNumberOfPlayers(playerNames);
        createPlayersByName(playerNames);
    }

    public int count() {
        return players.size();
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    private void createPlayersByName(final List<String> playerNames) {
        players = playerNames.stream()
                .map(inputName -> new Player(new Name(inputName)))
                .collect(Collectors.toList());
    }

    private void validateDuplicatedNames(final List<String> playerNames) {
        int numberOfNotDuplicatedPlayers = Set.copyOf(playerNames).size();

        if (numberOfNotDuplicatedPlayers != playerNames.size()) {
            throw new IllegalArgumentException("플레이어의 이름이 중복됩니다.");
        }
    }

    private void validateNumberOfPlayers(final List<String> playerNames) {
        if (playerNames.size() < MINIMUM_COUNT_OF_PLAYERS) {
            throw new IllegalArgumentException("플레이어의 수는 2명 이상이어야 합니다.");
        }
    }

}
