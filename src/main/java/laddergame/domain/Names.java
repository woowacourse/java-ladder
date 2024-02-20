package laddergame.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Names {

    private final List<Name> names;

    public Names(final List<String> input) {
        final List<Name> names = convertToNames(input);
        validateDuplication(names);

        this.names = names;
    }

    private List<Name> convertToNames(final List<String> input) {
        return input.stream()
                .map(Name::new)
                .toList();
    }

    private void validateDuplication(final List<Name> names) {
        if (names.size() != Set.copyOf(names).size()) {
            throw new IllegalArgumentException("[ERROR] 이름은 중복 될 수 없습니다.");
        }
    }

    public int getMaxLengthSkipFirst() {
        return names.stream()
                .map(Name::getLength)
                .skip(1)
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    public int getLastLength() {
        return names.get(names.size() - 1).getLength();
    }

    public int size() {
        return names.size();
    }

    public List<String> getNames() {
        return names.stream()
                .map(Name::getName)
                .toList();
    }

    public int getFirstNameLength() {
        return names.get(0).getLength();
    }
}
