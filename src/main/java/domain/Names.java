package domain;

import java.util.List;

public class Names {

    public static final String DUPLICATED_NAMES = "참가자의 이름은 중복될 수 없습니다.";
    private static final int MINIMUM_PLAYERS_COUNT = 2;
    private static final int MAXIMUM_PLAYERS_COUNT = 10;
    public static final String INVALID_NAMES_COUNT = "이름은 " + MINIMUM_PLAYERS_COUNT + "개 이상 " + MAXIMUM_PLAYERS_COUNT + "개 이하 이어야 합니다.";

    private final List<Name> values;

    public Names(final List<String> values) {
        validateNameCount(values.size());
        validateDuplicatedNames(values);
        this.values = values.stream()
                .map(Name::new)
                .toList();
    }

    private void validateNameCount(final int count) {
        if (count < MINIMUM_PLAYERS_COUNT || count > MAXIMUM_PLAYERS_COUNT) {
            throw new IllegalArgumentException(INVALID_NAMES_COUNT);
        }
    }

    private void validateDuplicatedNames(final List<String> values) {
        if (values.size() != values.stream().distinct().toList().size()) {
            throw new IllegalArgumentException(DUPLICATED_NAMES);
        }
    }

    public int count() {
        return values.size();
    }

    public Name findNameAtIndex(int index) {
        return values.get(index);
    }

    public List<Name> getValues() {
        return values;
    }
}
