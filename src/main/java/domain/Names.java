package domain;

import java.util.HashSet;
import java.util.List;

public class Names {
    private final List<String> names;

    public Names(List<String> names) {
        validateDuplicateName(names);
        this.names = names;
    }

    private void validateDuplicateName(List<String> names) {
        if (names.size() != new HashSet<>(names).size()) {
            throw new IllegalArgumentException("참가자 이름은 중복일 수 없습니다.");
        }
    }

    public List<String> getNames() {
        return names;
    }
}
