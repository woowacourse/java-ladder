package domain;

import java.util.List;
import java.util.stream.IntStream;

public class Participants {

    public static final int MIN_OF_PARTICIPANTS_COUNT = 2;
    public static final int MAX_OF_PARTICIPANTS_COUNT = 50;
    public static final String OUT_OF_RANGE_PARTICIPANTS_COUNT =
            "[ERROR] 참가자는 " + MIN_OF_PARTICIPANTS_COUNT + "명 이상 " + MAX_OF_PARTICIPANTS_COUNT + "명 이하여야 합니다.";
    public static final String DUPLICATE_PARTICIPANTS = "[ERROR] 참가자 이름은 중복될 수 없습니다.";

    private final List<Player> players;

    public Participants(List<String> names) {
        validateCount(names);
        validateDuplicate(names);
        this.players = IntStream.range(0, names.size())
                .mapToObj(i -> new Player(names.get(i), i))
                .toList();
    }

    private void validateCount(List<String> names) {
        if (names.size() < MIN_OF_PARTICIPANTS_COUNT || MAX_OF_PARTICIPANTS_COUNT < names.size()) {
            throw new IllegalArgumentException(OUT_OF_RANGE_PARTICIPANTS_COUNT);
        }
    }

    private void validateDuplicate(List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_PARTICIPANTS);
        }
    }

    public int getCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
