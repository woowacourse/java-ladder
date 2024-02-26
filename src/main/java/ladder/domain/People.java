package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class People {

    private static final int MIN_PEOPLE_COUNT = 3;

    private final List<Name> names;

    public People(List<Name> names) {
        validate(names);
        this.names = new ArrayList<>(names);
    }

    private void validate(List<Name> names) {
        validateDuplication(names);
        validateCount(names);
    }

    private void validateDuplication(List<Name> names) {
        long uniqueCount = names.stream()
                .distinct()
                .count();

        if (uniqueCount != names.size()) {
            throw new IllegalArgumentException("이름은 중복일 수 없습니다.");
        }
    }

    private void validateCount(List<Name> names) {
        if (names.size() < MIN_PEOPLE_COUNT) {
            throw new IllegalArgumentException("최소 인원은 세명입니다.");
        }
    }

    public int count() {
        return names.size();
    }

    public int findMaxNameLength() {
        return names.stream()
                .mapToInt(Name::getLength)
                .max()
                .orElse(0);
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }
}
