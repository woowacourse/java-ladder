package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private static final int MIN_PARTICIPANTS_SIZE = 2;
    private static final String PARTICIPANTS_NULL_EXCEPTION = "참여자 이름 목록은 null이 될 수 없습니다.";
    private static final String PARTICIPANTS_MIN_SIZE_EXCEPTION = "참여자 이름 목록은 2명 미만이 될 수 없습니다.";

    private final List<Name> names;

    public Participants(final List<Name> names) {
        validateParticipants(names);
        this.names = names;
    }

    private void validateParticipants(final List<Name> names) {
        if (names == null) {
            throw new IllegalArgumentException(PARTICIPANTS_NULL_EXCEPTION);
        }
        if (names.size() < MIN_PARTICIPANTS_SIZE) {
            throw new IllegalArgumentException(PARTICIPANTS_MIN_SIZE_EXCEPTION);
        }
    }

    public int getSize() {
        return names.size();
    }

    public List<String> getNames() {
        return names.stream()
                .map(Name::getValue)
                .collect(Collectors.toUnmodifiableList());
    }
}
