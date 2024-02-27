package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    public static final String INVALID_NAMES_COUNT = "이름은 2개 이상 10개 이하 이어야 합니다.";
    private static final int MINIMUM_PLAYERS_COUNT = 2;
    private static final int MAXIMUM_PLAYERS_COUNT = 10;

    private final List<Name> values;

    public Names(final List<String> values) {
        validateNameCount(values.size());
        this.values = values.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private void validateNameCount(final int count) {
        if (count < MINIMUM_PLAYERS_COUNT || count > MAXIMUM_PLAYERS_COUNT) {
            throw new IllegalArgumentException(INVALID_NAMES_COUNT);
        }
    }

    public int count() {
        return values.size();
    }

    public List<Name> getValues() {
        return Collections.unmodifiableList(values);
    }
}
