package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    private static final int SIZE_LOWER_BOUND = 2;
    private static final String INVALID_SIZE_MESSAGE = "참가자는 2명 이상이어야 합니다.";
    private static final String CAN_NOT_FIND_NAME_MESSAGE = "존재하지 않는 이름입니다.";

    private final List<Player> players;

    public Players(final List<String> names) {
        validate(names);

        players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private void validate(final List<String> names) {
        validateNames(names);
    }

    private void validateNames(final List<String> names) {
        if (names.size() < SIZE_LOWER_BOUND) {
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
        }
    }

    public int findIndexByName(final Name name) {
        return IntStream.range(0, players.size())
                .filter(i -> players.get(i).hasSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(CAN_NOT_FIND_NAME_MESSAGE));
    }

    public String getPlayerName(final int index) {
        Player player = players.get(index);

        return player.getName();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int getNumberOfPlayer() {
        return players.size();
    }
}
