package domain.model;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final int MIN_SIZE = 2;
    private static final int MAX_SIZE = 100;
    private static final String INVALID_SIZE_ERROR_MESSAGE = "참가자는 " + MIN_SIZE + "~" + MAX_SIZE + "명입니다.";
    private static final String DUPLICATE_NAME_ERROR_MESSAGE = "중복된 이름은 허용되지 않습니다.";
    private final List<Player> players;

    public Players(final List<String> names) {
        validate(names);
        this.players = makePlayers(names);
    }

    private void validate(final List<String> names) {
        validateSize(names);
        validateDuplicate(names);
    }

    private void validateSize(final List<String> names) {
        if (names.size() < MIN_SIZE || names.size() > MAX_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicate(final List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }

    private List<Player> makePlayers(final List<String> names) {
        return names.stream()
            .map(Player::new)
            .collect(Collectors.toUnmodifiableList());
    }

    public int size() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
