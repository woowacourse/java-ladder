package model;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Names {

    private final Set<Name> names = new LinkedHashSet<>();

    public Names(List<String> input) {
        validateDuplicateName(input);
        validateMinPlayers(input.size());

        for (String name : input) {
            names.add(new Name(name));
        }
    }

    public List<String> getNames() {
        return this.names.stream()
            .map(Name::getName)
            .collect(Collectors.toList());
    }

    private void validateDuplicateName(List<String> names) {
        long distinct = names.stream().distinct().count();
        if (distinct < names.size()) {
            throw new IllegalArgumentException("이름에 중복이 존재할 수 없습니다");
        }
    }

    private void validateMinPlayers(int playerNum) {
        if (playerNum < 2) {
            throw new IllegalArgumentException("최소 두 명의 참가자가 있어야 합니다");
        }
    }


}
