package ladderGame.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Players {
    private static final String EXCEPTION_MESSAGE_DUPLICATION_NAME = "참여자들의 이름은 중복될 수 없습니다.";
    private static final String EXCEPTION_MESSAGE_LESS_THAN_MINIMUM = "참여자의 이름은 두 개 이상이어야 합니다.";
    private static final int MINIMUM_NAME_COUNT = 2;
    private final List<Player> players;

    public Players(List<String> names) {
        validate(names);

        players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name));
        }
    }

    private void validate(List<String> names) {
        validateNotDuplicationName(names);
        validatePlayerCount(names);
    }

    private void validateNotDuplicationName(List<String> names) {
        if (new HashSet<>(names).size() != names.size()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_DUPLICATION_NAME);
        }
    }

    private void validatePlayerCount(List<String> names) {
        if (names.size() < MINIMUM_NAME_COUNT) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_LESS_THAN_MINIMUM);
        }
    }

    public int getPlayerSize() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }
}
