package laddergame;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names;

    public Names(final List<Name> names) {
        validateDuplication(names);
        this.names = names;
    }

    public List<Integer> getNameSizes() {
        return names.stream().map(Name::getLength).collect(Collectors.toList());
    }

    private void validateDuplication(final List<Name> names) {
        if (names.size() != Set.copyOf(names).size()) {
            throw new IllegalArgumentException("[ERROR] 이름은 중복 될 수 없습니다.");
        }
    }
}
