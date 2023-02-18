package domain.value;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Names {

    private static final int MIN_PERSON_COUNT_INCLUSIVE = 2;
    private static final int FIRST_NAME_INDEX = 0;

    private final List<Name> names;

    public Names(final List<Name> names) {
        validateDuplicateName(names);
        validateSize(names);
        this.names = new ArrayList<>(names);
    }

    private void validateDuplicateName(final List<Name> names) {
        if (names.size() != new HashSet<>(names).size()) {
            throw new IllegalArgumentException("동명이인은 불가능합니다.");
        }
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

    public int indexOf(final Name name) {
        return names.indexOf(name);
    }

    public Name get(final int index) {
        return names.get(index);
    }
}
