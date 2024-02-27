package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class People {

    private static final int MIN_SIZE = 2;
    private static final int MAX_LENGTH = 5;

    private final List<String> names;

    public People(List<String> names) {
        validate(names);
        this.names = new ArrayList<>(names);
    }

    private void validate(List<String> names) {
        validateMinSize(names);
        validateMinLength(names);
        validateMaxLength(names);
    }

    private void validateMinSize(List<String> names) {
        if (names.size() < MIN_SIZE) {
            throw new IllegalArgumentException("이름이 두 개 이상이 아닙니다.");
        }
    }

    private void validateMinLength(List<String> names) {
        long count = names.stream()
                .filter(String::isEmpty)
                .count();

        if (count > 0) {
            throw new IllegalArgumentException("1글자 이상이 아닌 이름이 있습니다.");
        }
    }

    private void validateMaxLength(List<String> names) {
        long count = names.stream()
                .filter(name -> name.length() > MAX_LENGTH)
                .count();

        if (count > 0) {
            throw new IllegalArgumentException("5글자 이하가 아닌 이름이 있습니다.");
        }
    }

    public int count() {
        return names.size();
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(names);
    }
}
