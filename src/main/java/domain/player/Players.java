package domain.player;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class Players {

    private static final int MIN_PLAYERS_SIZE = 2;
    private static final int MAX_PLAYERS_SIZE = 10;

    private final List<Name> names;

    public Players(List<String> names) {
        validateSize(names);
        validateUniqueNames(names);

        this.names = names.stream()
                .map(Name::new)
                .toList();
    }

    public List<String> getRawNames() {
        return names.stream()
                .map(Name::rawName)
                .toList();
    }

    public int size() {
        return names.size();
    }

    public Name get(int index) {
        validateIndex(index);
        return names.get(index);
    }

    public int getIndexByName(String name) {
        return IntStream.range(0, names.size())
                .filter(index -> hasSameNameOnIndex(name, index))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 이름입니다."));
    }

    private boolean hasSameNameOnIndex(String name, int index) {
        return names.get(index)
                .rawName()
                .equals(name);
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= names.size()) {
            throw new IndexOutOfBoundsException("주어진 인덱스가 범위를 벗어납니다.");
        }
    }

    private void validateSize(List<String> names) {
        if (names.size() < MIN_PLAYERS_SIZE || names.size() > MAX_PLAYERS_SIZE) {
            throw new IllegalArgumentException("참여하는 사람의 수는 2명 이상 10명 이하여야 합니다.");
        }
    }

    private void validateUniqueNames(List<String> names) {
        int uniqueNameCount = (int) names.stream()
                .distinct()
                .count();
        if (names.size() != uniqueNameCount) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }
}
