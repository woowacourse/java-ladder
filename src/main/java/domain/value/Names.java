package domain.value;

import java.util.ArrayList;
import java.util.List;

public class Names {

    private static final int MIN_PERSON_COUNT_INCLUSIVE = 2;
    private static final int FIRST_NAME_INDEX = 0;

    private final List<Name> names;

    public Names(final List<Name> names) {
        validateSize(names);
        this.names = new ArrayList<>(names);
    }

    private void validateSize(final List<Name> names) {
        if (names.size() < MIN_PERSON_COUNT_INCLUSIVE) {
            throw new IllegalArgumentException("2명 이상의 사람들을 입력해주세요");
        }
    }

    public int firstNameLength() {
        return names.get(FIRST_NAME_INDEX).length();
    }

    public List<Name> getNames() {
        return new ArrayList<>(names);
    }

    public int size() {
        return names.size();
    }
}
