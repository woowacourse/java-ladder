package laddergame.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Participants {
    private final List<Name> names;

    public Participants(final List<Name> names) {
        validateNotNull(names);
        validateNotEmpty(names);
        this.names = names;
    }

    private void validateNotEmpty(final List<Name> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("참여자 이름 목록은 비어있을 수 없습니다.");
        }
    }

    private void validateNotNull(final List<Name> names) {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException("참여자 이름 목록은 null이 될 수 없습니다.");
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
