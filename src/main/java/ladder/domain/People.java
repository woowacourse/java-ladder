package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class People {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_PEOPLE_COUNT = 3;
    private static final String DELIMITER = ",";

    private final List<String> names;

    public People(String rawNames) {
        List<String> names = parse(rawNames);
        validate(names);
        this.names = new ArrayList<>(names);
    }

    private List<String> parse(String rawNames) {
        String[] names = rawNames.split(DELIMITER);
        return Arrays.stream(names)
                .map(String::trim)
                .filter(name -> !name.isBlank())
                .toList();
    }

    private void validate(List<String> names) {
        for (String name : names) {
            validateLength(name);
        }
        validateDuplication(names);
        validateCount(names);
    }

    private void validateLength(String name) {
        int nameLength = name.length();
        if (nameLength > MAX_NAME_LENGTH || nameLength < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 공백을 제외한 최소 1글자 최대 5글자까지 부여할 수 있습니다.");
        }
    }

    private void validateDuplication(List<String> names) {
        long uniqueCount = names.stream()
                .distinct()
                .count();

        if (uniqueCount != names.size()) {
            throw new IllegalArgumentException("이름은 중복일 수 없습니다.");
        }
    }

    private void validateCount(List<String> names) {
        if (names.size() < MIN_PEOPLE_COUNT) {
            throw new IllegalArgumentException("최소 인원은 세명입니다.");
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
