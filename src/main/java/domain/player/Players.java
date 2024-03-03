package domain.player;

import java.util.Collections;
import java.util.List;

public class Players {
    private static final String DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 중복된 이름이 존재합니다.";
    private static final String OUT_OF_BOUND_EXCEPTION_MESSAGE = "[ERROR] 범위를 벗어난 값은 입력할 수 없습니다.";
    public static final String NO_RESULT_FOUND_EXCEPTION_MESSAGE = "[ERROR] 존재하지 않는 이름입니다.";

    private final List<Player> players;

    public Players(final List<Player> players) {
        validateDuplicate(players);
        this.players = players;
    }

    private void validateDuplicate(List<Player> players) {
        if (getUniquePlayerSize(players) != players.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private long getUniquePlayerSize(final List<Player> players) {
        return players.stream()
                .distinct()
                .count();
    }

    public Player findPlayerByIndex(final int index) {
        if (index < 0 || players.size() <= index) {
            throw new IllegalArgumentException(OUT_OF_BOUND_EXCEPTION_MESSAGE);
        }

        return players.get(index);
    }

    public Player findPlayerByName(final String name) {
        return players.stream()
                .filter(player -> name.equals(player.getName()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NO_RESULT_FOUND_EXCEPTION_MESSAGE));
    }

    public int findMaxNameLength() {
        return players.stream()
                .mapToInt(player -> player.getName().length())
                .max()
                .orElse(0);
    }

    public int getPlayerCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
