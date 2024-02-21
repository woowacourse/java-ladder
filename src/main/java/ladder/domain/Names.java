package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private static final int MAX_NAME_LENGTH = 5;

    private final List<String> names;

    public Names(String rawNames) {
        String[] names = rawNames.split(",");
        validate(names);
        this.names = new ArrayList<>(List.of(names));
    }

    private static void validate(String[] names) {
        long count = Arrays.stream(names)
                .filter(name -> name.length() > MAX_NAME_LENGTH)
                .count();

        if (count > 0) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 부여할 수 있습니다.");
        }
    }

    public int getSize() {
        return names.size();
    }

    @Override
    public String toString() {
        return names.stream().map(name -> String.format("%-7s", name)).collect(Collectors.joining());
    }
}
