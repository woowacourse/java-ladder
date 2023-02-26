package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Names {
    private static final int MINUS_VALUE_FOR_LADDER_WIDTH = 1;
    private static final int MIN_NAME_INCLUSIVE = 2;
    private static final String ERROR_MIN_PEOPLE = "[ERROR] " + MIN_NAME_INCLUSIVE + "명 이상의 사람들을 입력해주세요";
    private static final String ERROR_NAME_SEARCH_ERROR = "해당하는 값이 없습니다";

    private final List<Name> names;

    public Names(final List<Name> names) {
        validateNames(names);
        this.names = new ArrayList<>(names);
    }

    private void validateNames(final List<Name> names) {
        if (names.size() < MIN_NAME_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_MIN_PEOPLE);
        }
    }

    public int getNameIndexByValue(final String value) {
        return IntStream.range(0, names.size())
                .filter(nameIndex -> names.get(nameIndex).getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_NAME_SEARCH_ERROR));
    }

    public int size() {
        return names.size();
    }

    public boolean isNotExistUser(final String targetName) {
        return names.stream()
                .allMatch(name -> !name.getValue().equals(targetName));
    }

    public List<Name> getNames() {
        return new ArrayList<>(names);
    }

    public Name getNameByIndex(final int index) {
        return names.get(index);
    }
}