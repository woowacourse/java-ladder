package ladder.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

class LadderGamePlayers {
    private static final String DUPLICATION_EXCEPTION_MESSAGE = "이름은 중복을 허용하지 않습니다.";
    private static final String DEFALT_LENGTH_FORMAT = "%-6s";

    private List<Player> players;

    LadderGamePlayers(List<String> names) {
        validationDuplication(names);
        this.players = names.stream().map(Player::new).collect(Collectors.toList());
    }

    private void validationDuplication(List<String> names) {
        if (names.size() != new HashSet<>(names).size()) {
            throw new IllegalArgumentException(DUPLICATION_EXCEPTION_MESSAGE);
        }
    }

    int size() {
        return players.size();
    }

    Player get(int i) {
        return players.get(i);
    }

    @Override
    public String toString() {
        return players.stream().map(player -> String.format(DEFALT_LENGTH_FORMAT, player.getName())).collect(Collectors.joining());
    }
}
