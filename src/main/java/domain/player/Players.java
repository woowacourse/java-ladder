package domain.player;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;

public class Players {
    private static final int MINIMUM_NUMBER_OF_PLAYERS = 2;
    private static final int MAXIMUM_NUMBER_OF_PLAYERS = 50;
    private static final String DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 중복된 이름이 존재합니다.";
    private static final String INVALID_PLAYER_COUNT_EXCEPTION_MESSAGE = "[ERROR] 참가자는 %d ~ %d명이어야 합니다.";

    private final List<Name> names;

    private Players(final List<Name> names) {
        validateNumberOfPlayers(names);
        validateDuplicateName(names);
        this.names = names;
    }

    public static Players from(List<String> rawNames) {
        return rawNames.stream()
                .map(Name::new)
                .collect(collectingAndThen(toList(), Players::new));
    }

    private void validateNumberOfPlayers(List<Name> names) {
        if (names.size() < MINIMUM_NUMBER_OF_PLAYERS || names.size() > MAXIMUM_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException(
                    String.format(INVALID_PLAYER_COUNT_EXCEPTION_MESSAGE, MINIMUM_NUMBER_OF_PLAYERS,
                            MAXIMUM_NUMBER_OF_PLAYERS)
            );
        }
    }

    private void validateDuplicateName(List<Name> names) {
        if (getUniqueNameCount(names) != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private long getUniqueNameCount(final List<Name> names) {
        return names.stream()
                .distinct()
                .count();
    }

    public int findMaxNameLength() {
        return names.stream()
                .mapToInt(Name::getLength)
                .max()
                .orElse(0);
    }

    public List<String> getNames() {
        return names.stream()
                .map(Name::getValue)
                .toList();
    }

    public int getPlayerCount() {
        return names.size();
    }
}
