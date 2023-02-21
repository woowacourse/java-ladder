package model;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Names {

    private static final int MINIMUM_PARTICIPANTS_SIZE = 2;

    private final List<Name> names;

    public Names(List<Name> names) {
        validateNames(names);

        this.names = names;
    }

    private void validateNames(List<Name> names) {
        if (Objects.isNull(names)) {
            throw new IllegalStateException("참가자 이름이 정상적으로 입력되지 않았습니다.");
        }
        if (names.size() < MINIMUM_PARTICIPANTS_SIZE) {
            throw new IllegalArgumentException("최소 2명의 이름을 입력해주세요.");
        }
        if (names.size() != calculateDistinctNameSize(names)) {
            throw new IllegalArgumentException("참가자의 이름은 중복될 수 없습니다.");
        }
    }

    private long calculateDistinctNameSize(List<Name> names) {
        return names.stream().distinct().count();
    }

    public String findNameByIndex(int index) {
        Name target = names.get(index);

        return target.getName();
    }

    public int findIndexByName(String name) {
        return IntStream.range(0, names.size())
                .filter(i -> names.get(i).matchesByName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("입력한 이름의 참가자가 없습니다."));
    }

    public int getTotalParticipantSize() {
        return names.size();
    }
}
