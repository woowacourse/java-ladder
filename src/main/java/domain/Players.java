package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    public Players(final List<String> playerNames) {
        validateNumberOfPlayers(playerNames);
        validateDuplicatedPlayers(playerNames);
        this.players = makePlayers(playerNames);
    }

    // TODO: 예외 메시지 작성
    private void validateNumberOfPlayers(final List<String> playerNames) {
        if (playerNames.size() <= 1 || playerNames.size() > 10) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicatedPlayers(final List<String> playerNames) {
        Set<String> nameWithoutDuplicated = new HashSet<>();

        for (String playerName : playerNames) {
            nameWithoutDuplicated.add(playerName);
        }

        if (playerNames.size() != nameWithoutDuplicated.size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Player> makePlayers(final List<String> playerNames) {
        return playerNames.stream()
                .map(name -> new Player(name))
                .collect(Collectors.toUnmodifiableList());
    }

    public int findLongestPlayerName() {
        return players.stream()
                .mapToInt(player -> player.getName().length())
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }
}
