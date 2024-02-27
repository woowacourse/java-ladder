package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

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
        return IntStream.range(0, names.size())
                .filter((index) -> names.get(index).isSameName(findName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이름입니다."));
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
