package laddergame.domain;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Names {
    private static final int MIN_PARTICIPANTS_SIZE = 2;
    private static final int MIN_NAME_LENGTH = 0;
    private static final String NAMES_MIN_SIZE_EXCEPTION = "Names 리스트는 {0}명 미만이 될 수 없습니다.";
    private static final String NAME_NOT_EXISTS_EXCEPTION = "Names에서 {0} 라는 이름을 찾을 수 없습니다.";

    private final List<Name> names;

    public Names(final List<String> inputNameValues) {
        final List<String> names = getNames(inputNameValues);
        validateNames(names);
        this.names = createNames(names);
    }

    public Position findPositionByName(final String name) {
        final int position = IntStream.range(0, names.size())
                .filter(nameIndex -> names.get(nameIndex).isSame(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(MessageFormat.format(NAME_NOT_EXISTS_EXCEPTION, name)));
        return new Position(position);
    }

    public Name findNameByPosition(final Position position) {
        return names.get(position.getValue());
    }

    public int getMaxNameLength() {
        return names.stream()
                .map(Name::getValue)
                .mapToInt(String::length)
                .max()
                .orElse(MIN_NAME_LENGTH);
    }

    public int getSize() {
        return names.size();
    }

    public List<String> getNameValues() {
        return names.stream()
                .map(Name::getValue)
                .collect(Collectors.toList());
    }

    public List<Name> getNames() {
        return new ArrayList<>(names);
    }

    private List<Name> createNames(final List<String> names) {
        return names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private List<String> getNames(final List<String> inputNameValues) {
        return Optional.ofNullable(inputNameValues).orElse(List.of());
    }

    private void validateNames(final List<String> names) {
        if (names.size() < MIN_PARTICIPANTS_SIZE) {
            throw new IllegalArgumentException(
                    MessageFormat.format(NAMES_MIN_SIZE_EXCEPTION, MIN_PARTICIPANTS_SIZE));
        }
    }
}
