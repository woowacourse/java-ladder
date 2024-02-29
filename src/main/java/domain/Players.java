package domain;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private static final int MIN_PLAYER = 2;
    private static final int MAX_PLAYER = 10;

    private final List<Name> players;

    public Players (List<String> names) {
        validateNumber(names);
        this.players = names.stream()
                .map(Name::new)
                .toList();
    }

    private void validateNumber(List<String> names) {
        if (names.size() < MIN_PLAYER || names.size() > MAX_PLAYER) {
            throw new IllegalArgumentException(String.format("이름의 수는 %d이상 %d이하여야 합니다.", MIN_PLAYER, MAX_PLAYER));
        }
    }

    public List<Name> getPlayers() {
        return new ArrayList<>(players);
    }

    public int getPlayersNumber() {
        return players.size();
    }
}
