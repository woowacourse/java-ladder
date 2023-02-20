package laddergame.domain;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Names {
    private static final int MIN_PARTICIPANTS_SIZE = 2;
    private static final String PARTICIPANTS_MIN_SIZE_EXCEPTION = "Names 리스트는 {0}명 미만이 될 수 없습니다.";

    private final List<Name> names;

    public Names(final List<String> inputNameValues) {
        final List<String> names = Optional.ofNullable(inputNameValues).orElse(List.of());
        validateNames(names);
        this.names = createNames(names);
    }

    public int getSize() {
        return names.size();
    }

    public List<Name> getNames() {
        return new ArrayList<>(names);
    }

    private List<Name> createNames(final List<String> names) {
        return names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private void validateNames(final List<String> names) {
        if (names.size() < MIN_PARTICIPANTS_SIZE) {
            throw new IllegalArgumentException(
                    MessageFormat.format(PARTICIPANTS_MIN_SIZE_EXCEPTION, MIN_PARTICIPANTS_SIZE));
        }
    }
}
