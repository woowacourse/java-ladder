package domain;

import constant.domain.ParticipantsExceptionMessage;

import java.util.List;
import java.util.stream.IntStream;

public class Participants {

    public static final int MIN_OF_PARTICIPANTS_COUNT = 2;
    public static final int MAX_OF_PARTICIPANTS_COUNT = 50;

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
            throw new IllegalArgumentException(ParticipantsExceptionMessage.OUT_OF_RANGE_PARTICIPANTS_COUNT.getExceptionMessage());
        }
    }

    private void validateDuplicate(List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw new IllegalArgumentException(ParticipantsExceptionMessage.DUPLICATE_PARTICIPANTS.getExceptionMessage());
        }
    }

    public int getCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
