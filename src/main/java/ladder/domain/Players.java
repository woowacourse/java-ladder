package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final int MINIMUM_PLAYERS_SIZE = 2;

    private final List<Player> players;

    public Players(String namesRaw) {
        List<String> names = splitNames(namesRaw);
        validatePlayersSize(names);
        this.players = generatePlayers(names);
    }

    private List<String> splitNames(String namesRaw) {
        return Arrays.stream(namesRaw.split(","))
                .collect(Collectors.toList());
    }

    private void validatePlayersSize(List<String> names) {
        if (names.size() < MINIMUM_PLAYERS_SIZE) {
            throw new IllegalArgumentException("플레이어는 최소 2명 이상이여야 합니다");
        }
    }

    private List<Player> generatePlayers(List<String> names) {
        List<Player> players = new ArrayList<>();
        for (int index = 0; index < names.size(); index++) {
            players.add(new Player(names.get(index), index));
        }
        return players;
    }

    public int getSize() {
        return players.size();
    }

    public List<String> getNameValues() {
        return players.stream()
                .map(Player::getName)
                .map(Name::value)
                .collect(Collectors.toList());
    }

    public Player getPlayerByName(String nameValue) {
        return players.stream()
                .filter(player -> player.haveNameOf(nameValue))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 플레이어의 이름입니다."));
    }
}
