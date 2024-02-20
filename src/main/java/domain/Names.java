package domain;

import java.util.List;

public class Names {
    private static final String DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 중복된 이름이 존재합니다.";

    private final List<Name> names;

    public Names(final List<Name> names) {
        validateDuplicateName(names);
        this.names = names;
    }

    private void validateDuplicateName(List<Name> names) {
        long distinctCount = names.stream()
                .distinct()
                .count();

        if (distinctCount != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }
}
