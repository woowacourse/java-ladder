package domain;

import java.util.ArrayList;
import java.util.List;

public class Names {
    private static final String ERROR_MIN_PEOPLE = "[ERROR] 2명 이상의 사람들을 입력해주세요";
    private static final int MIN_NAME_INCLUSIVE = 1;

    private final List<Name> names;

    public Names(final List<Name> names) {
        validateNames(names);
        this.names = new ArrayList<>(names);
    }

    private void validateNames(final List<Name> names) {
        if (names.size() == MIN_NAME_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_MIN_PEOPLE);
        }
    }

    public int size() {
        return names.size();
    }

    public List<Name> getNames() {
        return new ArrayList<>(names);
    }
}