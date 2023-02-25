package laddergame.domain.player;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;

public class Names {
    private static final int MIN_NUMBER_OF_PLAYERS = 2;

    private final List<Name> names;

    public Names(final List<String> names) {
        validateNumberOfNames(names);

        this.names = new ArrayList<>(createNames(names));
    }

    private void validateNumberOfNames(final List<String> names) {
        if (names.size() < MIN_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException("최소 2명 이상의 플레이어가 필요합니다.");
        }
    }

    private List<Name> createNames(final List<String> names) {
        return names.stream()
                .map(Name::new)
                .collect(toList());
    }

    public int findMaxNameLength() {
        return names.stream()
                .mapToInt(Name::getNameLength)
                .max()
                .orElseThrow(() -> new IllegalStateException("가장 긴 이름을 찾을 수 없습니다."));
    }

    public List<String> getNames() {
        return names.stream()
                .map(Name::getName)
                .collect(toUnmodifiableList());
    }

    public int getSize() {
        return names.size();
    }
}
