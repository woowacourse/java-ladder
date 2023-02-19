package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private static final String PARTICIPANTS_NULL_EXCEPTION = "참여자 이름 목록은 null이 될 수 없습니다.";

    private final Names names;

    public Participants(final List<String> names) {
        validateParticipants(names);
        this.names = new Names(names);
    }

    private void validateParticipants(final List<String> names) {
        if (names == null) {
            throw new IllegalArgumentException(PARTICIPANTS_NULL_EXCEPTION);
        }
    }

    public int getSize() {
        return names.getSize();
    }

    public List<String> getNames() {
        return names.getNames()
                .stream()
                .map(Name::getValue)
                .collect(Collectors.toList());
    }
}
