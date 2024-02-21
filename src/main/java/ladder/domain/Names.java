package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private static final int MAX_NAME_LENGTH = 5;

    private final List<String> names;

    public Names(String rawNames) {
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

    //todo : 가장 긴 이름의 길아 반환하는 메서드

    @Override
    public String toString() {
        return names.stream()
                .map(name -> String.format("%-7s", name))
                .collect(Collectors.joining());
    }
}
