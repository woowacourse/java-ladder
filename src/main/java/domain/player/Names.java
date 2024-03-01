package domain.player;

import java.util.List;

public class Names {

    private static final int MIN_PLAYER_COUNT = 2;
    private static final int MAX_PLAYER_COUNT = 10;

    private final List<Name> names;

    public static Names of(final List<String> rawNames) {
        final List<Name> names = rawNames.stream()
                .map(Name::new)
                .toList();
        return new Names(names);
    }

    public Names(final List<Name> names) {
        validateCount(names.size());
        this.names = names;
    }

    private void validateCount(final int count) {
        if (count < MIN_PLAYER_COUNT || count > MAX_PLAYER_COUNT) {
            throw new IllegalArgumentException(
                    String.format("참가자 수는 %d명 이상 %d명 이하 이어야 합니다.", MIN_PLAYER_COUNT, MAX_PLAYER_COUNT));
        }
    }

    public Name getBy(final int index) {
        return names.get(index);
    }

    public List<String> getValues() {
        return names.stream()
                .map(Name::value)
                .toList();
    }

    public int count() {
        return names.size();
    }
}
