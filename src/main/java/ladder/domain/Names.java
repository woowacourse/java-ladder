package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

}
