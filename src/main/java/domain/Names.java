package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Names {

    private static final int MIN_NAME_SIZE = 2;

    private final List<Name> names;

    public Names(List<Name> names) {
        validate(names);
        this.names = new ArrayList<>(names);
    }

    private void validate(List<Name> names) {
        validateSize(names);
        validateDuplicate(names);
    }

    private void validateSize(List<Name> names) {
        if (names.size() < MIN_NAME_SIZE) {
            throw new IllegalArgumentException(String.format("이름은 최소 2개 이상이여햡니다. 입력값 : %d", names.size()));
        }
    }

    private void validateDuplicate(List<Name> names) {
        if (new HashSet<>(names).size() != names.size()) {
            throw new IllegalArgumentException("이름은 중복 될 수 없습니다.");
        }
    }

    public int getSize() {
        return names.size();
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }
}
