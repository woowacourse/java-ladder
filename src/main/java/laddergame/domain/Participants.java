package laddergame.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Participants {
    private static final String PARTICIPANTS_EMPTY_EXCEPTION = "입력된 참여자 이름 목록이 비어있을 수 없습니다.";

    private final Names names;

    public Participants(final List<String> nameValues) {
        final List<String> names = Optional.ofNullable(nameValues).orElse(List.of());
        validateParticipants(names);
        this.names = new Names(names);
    }

    private void validateParticipants(final List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(PARTICIPANTS_EMPTY_EXCEPTION);
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
