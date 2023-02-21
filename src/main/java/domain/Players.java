package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    private static final int SIZE_LOWER_BOUND = 2;
    private static final String INVALID_SIZE_MESSAGE = "참가자는 2명 이상이어야 합니다.";
    private static final String CAN_NOT_FIND_NAME_MESSAGE = "존재하지 않는 이름입니다.";

    private final List<Name> names;

    public Players(final List<String> names) {
        validate(names);

        this.names = names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private void validate(final List<String> names) {
        validateNames(names);
    }

    private void validateNames(final List<String> names) {
        if (names.size() < SIZE_LOWER_BOUND) {
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
        }
    }

    public int findByName(String name) {
        return IntStream.range(0, names.size())
                .filter(i -> names.get(i).getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(CAN_NOT_FIND_NAME_MESSAGE));
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }

    public int getNumberOfPlayer() {
        return names.size();
    }
}
