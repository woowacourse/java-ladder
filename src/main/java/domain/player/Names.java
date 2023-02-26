package domain.player;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Names {
    private static final int MIN_RANGE = 2;
    private static final int MAX_RANGE = 100;

    private final List<Name> names;

    public Names(List<String> names) {
        List<Name> formattedNames = formatNames(names);
        validateSize(formattedNames.size());
        validateDuplicatedNames(formattedNames);
        this.names = formattedNames;
    }

    private static List<Name> formatNames(List<String> names) {
        return names.stream()
                .map(String::trim)
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private static void validateSize(int personNumber) {
        if (personNumber < MIN_RANGE || personNumber > MAX_RANGE) {
            throw new IllegalArgumentException("2명 이상 100명 이하의 사람 수를 입력해 주세요.");
        }
    }

    private static void validateDuplicatedNames(List<Name> formattedNames) {
        if (formattedNames.stream().distinct().count() != formattedNames.size()) {
            throw new IllegalArgumentException("입력한 사용자 이름은 중복될 수 없습니다.");
        }
    }

    public Name findByName(String name) {
        return names.stream()
                .filter(element -> element.getValue().equals(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("해당하는 이름이 존재하지 않습니다."));
    }

    public Position initialPositionOf(Name name) {
        return new Position(names.indexOf(name));
    }

    public int size() {
        return names.size();
    }

    public List<Name> getNames() {
        return new ArrayList<>(names);
    }
}
