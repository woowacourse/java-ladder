package domain.player;

import java.util.List;

public class Names {

    private static final int MIN_PLAYER_SIZE = 2;

    private final List<Name> names;

    public Names(List<String> names) {
        validate(names);
        this.names = names.stream()
                .map(Name::new)
                .toList();
    }

    private void validate(List<String> names) {
        if (names.size() < MIN_PLAYER_SIZE) {
            throw new IllegalArgumentException("참여할 사람은 " + MIN_PLAYER_SIZE + "명 이상이어야 합니다.");
        }
    }

    public int size() {
        return names.size();
    }

    public List<String> getNames() {
        return names.stream()
                .map(Name::getName)
                .toList();
    }

    public Name get(int index) {
        return names.get(index);
    }
}
