package domain.name;

import java.util.HashSet;
import java.util.List;

public class Names {

    private static final int MIN_COUNT = 2;

    private final List<Name> names;

    private Names(List<Name> names) {
        validate(names);
        this.names = names;
    }

    public static Names from(List<String> names) {
        return new Names(names.stream()
                .map(Name::new)
                .toList());
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

    public int getNameCount() {
        return names.size();
    }

    public List<Name> getNames() {
        return List.copyOf(names);
    }

    public Name findName(String findingName) {
        return names.stream()
                .filter(name -> name.getName().equals(findingName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 찾는 이름이 없습니다."));
    }

    public int findIndex(String findingName) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).getName().equals(findingName)) {
                return i;
            }
        }
        throw new IllegalArgumentException("[ERROR] 찾는 이름이 목록에 없습니다.");
    }
}
