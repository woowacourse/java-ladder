package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private static final int SIZE_LOWER_BOUND = 2;
    private static final String INVALID_SIZE_MESSAGE = "참가자는 2명 이상이어야 합니다.";

    private final List<Name> names;

    public Names(List<String> names) {
        validate(names);

        this.names = names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private static void validate(List<String> names) {
        if (isValidSize(names)) {
            return;
        }

        throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
    }

    private static boolean isValidSize(List<String> names) {
        return names.size() >= SIZE_LOWER_BOUND;
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }

    public int getPersonCount() {
        return names.size();
    }
}
