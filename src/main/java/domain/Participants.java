package domain;

import java.util.List;
import java.util.Set;

public class Participants {

    private final List<String> names;
    public Participants(List<String> names) {
        validateDuplicatedNames(names);
        this.names = names;
    }

    private void validateDuplicatedNames(List<String> names) {
        if (names.size() != Set.copyOf(names).size()) {
            throw new IllegalArgumentException("참가자의 이름은 중복될 수 없습니다.");
        }
    }
}
