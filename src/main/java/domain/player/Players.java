package domain.player;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private static final String DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 중복된 이름이 존재합니다.";
    private static final String OUT_OF_BOUND_EXCEPTION_MESSAGE = "[ERROR] 범위를 벗어난 값은 입력할 수 없습니다.";

    private final List<Player> players;

    public Players(final List<Name> names) {
        players = new ArrayList<>();

        validateDuplicateName(names);
        names.forEach(this::addPlayer);
    }

    private void addPlayer(final Name name) {
        players.add(new Player(name, players.size()));
    }

    private void validateDuplicateName(List<Name> names) {
        if (getUniqueNamesSize(names) != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private long getUniqueNamesSize(final List<Name> names) {
        return names.stream()
                .distinct()
                .count();
    }

    public Player findPlayerByIndex(final int index) {
        if (index > 0 || players.size() <= index) {
            throw new IllegalArgumentException(OUT_OF_BOUND_EXCEPTION_MESSAGE);
        }

        return players.get(index);
    }

    public int findMaxNameLength() {
        return getNames().stream()
                .mapToInt(Name::getLength)
                .max()
                .orElse(0);
    }

    public int getPlayerCount() {
        return players.size();
    }

    public List<Name> getNames() {
        return players.stream()
                .map(Player::getName)
                .toList();
    }
}
