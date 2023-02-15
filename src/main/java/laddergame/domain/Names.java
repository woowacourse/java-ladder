package laddergame.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private final List<Name> names;

    public Names(final List<String> names) {
        validateNUmberOfNames(names);

        this.names = Collections.unmodifiableList(names.stream().map(Name::new)
                .collect(Collectors.toList()));
    }

    private void validateNUmberOfNames(final List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException();
        }
    }
}
