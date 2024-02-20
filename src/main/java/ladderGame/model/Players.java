package ladderGame.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Players {
    private static final String EXCEPTION_MESSAGE_DUPLICATION_NAME = "참여자들의 이름은 중복될 수 없습니다.";
    private static final String EXCEPTION_MESSAGE_LESS_THAN_MINIMUM = "참여자의 이름은 두 개 이상이어야 합니다.";
    private static final int MINIMUM_NAMES = 2;
    private final List<Player> players;

    public Players(List<String> names) {
        validate(names);

        players = new ArrayList<>();
        for(String name : names) {
            players.add(new Player(name));
        }
    }

    private void validate(List<String> names) {
        validateDuplicationName(names);
        validateLessThanMinimum(names);
    }

    private void validateDuplicationName(List<String> names) {
        if(new HashSet<>(names).size() != names.size()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_DUPLICATION_NAME);
        }
    }

    private void validateLessThanMinimum(List<String> names) {
        if(names.size() < MINIMUM_NAMES) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_LESS_THAN_MINIMUM);
        }
    }

    public int getPlayerSize() {
        return players.size();
    }
}
