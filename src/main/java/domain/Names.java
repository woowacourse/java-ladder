package domain;

import java.util.Collections;
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

    public int findIndex(String findName) {
        for (int i = 0; i < names.size(); i++) {
            Name name = names.get(i);
            if (name.isSameName(findName)) { // TODO 인덴트 줄이기
                return i;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 이름입니다.");
    }

    public Name findNameByString(String target) {
        return names.stream()
                .filter((name) -> name.isSameName(target))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이름입니다."));
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }
}
