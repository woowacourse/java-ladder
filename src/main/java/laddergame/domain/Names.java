package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Names {
    private static final int MIN_NUMBER_OF_PLAYERS = 2;
    private static final int HALF = 2;

    private final List<Name> names;

    public Names(final List<String> names) {
        validateNumberOfNames(names);

        this.names = new ArrayList<>(createNames(names));
    }

    public int findMaxNameLength() {
        return names.stream()
                .mapToInt(Name::getNameLength)
                .max()
                .orElseThrow(() -> new IllegalStateException("가장 긴 이름을 찾을 수 없습니다."));
    }

    public int getFirstNameLengthDividedByTwoRounded() {
        return Math.round(names.get(0).getNameLength() / HALF);
    }

    public List<String> getNames() {
        return names.stream()
                .map(Name::getName)
                .collect(toList());
    }

    public int getSize() {
        return names.size();
    }

    private static List<Name> createNames(final List<String> names) {
        return names.stream()
                .map(name -> new Name(name.trim()))
                .collect(toList());
    }

    private void validateNumberOfNames(final List<String> names) {
        if (names.size() < MIN_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException("최소 2명 이상의 플레이어가 필요합니다.");
        }
    }
}
