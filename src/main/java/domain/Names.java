package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Names {

    private static final int MINIMUM_LENGTH_OF_NAME = 2;
    private static final int MAXIMUM_LENGTH_OF_NAME = 10;

    private final List<Name> names;

    public Names(final List<String> names) {
        validateNumberOfNames(names);
        validateDuplicatedNames(names);
        this.names = makeNames(names);
    }

    private void validateNumberOfNames(final List<String> names) {
        if (isNotPermittedNumberOfPlayers(names)) {
            throw new IllegalArgumentException("참여 가능한 플레이어의 수는 2명이상 10명이하 입니다.");
        }
    }

    private boolean isNotPermittedNumberOfPlayers(List<String> names) {
        return (names.size() < MINIMUM_LENGTH_OF_NAME) || (names.size() > MAXIMUM_LENGTH_OF_NAME);
    }

    private void validateDuplicatedNames(final List<String> names) {
        Set<String> nameWithoutDuplicated = new HashSet<>(names);

        if (names.size() != nameWithoutDuplicated.size()) {
            throw new IllegalArgumentException("참가한 플레이어의 이름 중 중복된 이름이 존재하면 안됩니다.");
        }
    }

    private List<Name> makeNames(final List<String> names) {
        return names.stream()
                .map(Name::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public int findNumberOfNames() {
        return this.names.size();
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(this.names);
    }
}
