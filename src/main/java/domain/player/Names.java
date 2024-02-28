package domain.player;

import java.util.List;

public class Names {

    private static final int MIN_PLAYER_SIZE = 2;

    private final List<Name> names;

    public Names(List<String> names) {
        validate(names);
        this.names = names.stream()
                .map(String::strip)
                .map(Name::new)
                .toList();
    }

    private void validate(List<String> names) {
        if (names.size() < MIN_PLAYER_SIZE) {
            throw new IllegalArgumentException("참여할 사람은 " + MIN_PLAYER_SIZE + "명 이상이어야 합니다.");
        }
        if (hasDuplicatedName(names)) {
            throw new IllegalArgumentException("이름이 중복되어 있습니다.");
        }
        if (hasNameAll(names)) {
            throw new IllegalArgumentException("all 이라는 문자열은 이름으로 사용할 수 없습니다.");
        }
    }

    private boolean hasDuplicatedName(List<String> names) {
        int distinctNameSize = (int) names.stream()
                .distinct()
                .count();
        return distinctNameSize != names.size();
    }

    private boolean hasNameAll(List<String> names) {
        return names.stream()
                .anyMatch(name -> name.equalsIgnoreCase("all"));
    }

    public int size() {
        return names.size();
    }

    public Name get(int index) {
        return names.get(index);
    }

    public List<String> getNames() {
        return names.stream()
                .map(Name::getName)
                .toList();
    }
}
