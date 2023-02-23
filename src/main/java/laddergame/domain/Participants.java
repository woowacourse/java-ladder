package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

import static laddergame.utils.OptionalUtils.getValueAfterNullCheck;

public class Participants {
    private static final String PARTICIPANTS_EMPTY_EXCEPTION = "입력된 참여자 이름 목록이 비어있을 수 없습니다.";

    private final Names names;

    public Participants(final List<String> nameValues) {
        final List<String> names = getValueAfterNullCheck(nameValues);
        validateParticipants(names);
        this.names = new Names(names);
    }

    public Position findPositionByName(final String name) {
        return names.findPositionByName(name);
    }

    public Name findNameByPosition(final Position position) {
        return names.findNameByPosition(position);
    }

    public int getSize() {
        return names.getNames().size();
    }

    public Names getNames() {
        return names;
    }

    public List<String> getNameValues() {
        return names.getNames()
                .stream()
                .map(Name::getValue)
                .collect(Collectors.toList());
    }

    private void validateParticipants(final List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(PARTICIPANTS_EMPTY_EXCEPTION);
        }
    }
}
