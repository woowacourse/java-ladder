package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class People {

    private static final int MIN_PEOPLE_SIZE = 2;
    private static final int MAX_NAME_LENGTH = 5;

    private final List<String> names;

    public People(String rawNames) {
        List<String> names = parse(rawNames);
        validate(names);
        this.names = new ArrayList<>(names);
    }

    private List<String> parse(String rawNames) {
        String[] names = rawNames.split(",");
        return Arrays.stream(names)
                .map(String::trim)
                .toList();
    }

    private void validate(List<String> names) {
        validateMinSize(names);
        validateMinLength(names);
        validateMaxLength(names);
    }

    private void validateMinSize(List<String> names) {
        if (names.size() < MIN_PEOPLE_SIZE) {
            throw new IllegalArgumentException("사람이 최소 2명 필요합니다.");
        }
    }

    private void validateMinLength(List<String> names) {
        long count = names.stream()
                .filter(String::isEmpty)
                .count();

        if (count > 0) {
            throw new IllegalArgumentException("이름은 최소 1글자 부여해야 합니다.");
        }
    }

    private void validateMaxLength(List<String> names) {
        long count = names.stream()
                .filter(name -> name.length() > MAX_NAME_LENGTH)
                .count();

        if (count > 0) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 부여할 수 있습니다.");
        }
    }

    public int count() {
        return names.size();
    }

    public int findMaxNameLength() {
        return names.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(names);
    }
}
