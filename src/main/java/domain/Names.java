package domain;

import java.util.HashSet;
import java.util.List;

public class Names {

    private static final int MIN_COUNT = 2;

    private final List<Name> names;

    public Names(List<Name> names) {
        validate(names);
        this.names = names;
    }

    public int getNameCount() {
        return names.size();
    }

    public List<Name> getNames() {
        return List.copyOf(names);
    }

    public int indexOf(String input) {
        int index = names.indexOf(new Name(input));
        if (index == -1) {
            throw new IllegalArgumentException("[ERROR] 해당하는 이름을 찾을 수 없습니다");
        }
        return index;
    }

    private void validate(List<Name> names) {
        validateUnique(names);
        validateEntryAmount(names);
    }

    private void validateUnique(List<Name> names) {
        if (names.size() != new HashSet<>(names).size()) {
            throw new IllegalArgumentException("[ERROR] 이름은 중복될 수 없습니다");
        }
    }

    private void validateEntryAmount(List<Name> names) {
        if (names.size() < MIN_COUNT) {
            throw new IllegalArgumentException("[ERROR] 참여 인원은 " + MIN_COUNT + "명 이상이어야 합니다");
        }
    }
}
