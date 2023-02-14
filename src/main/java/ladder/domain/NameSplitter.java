package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameSplitter {

    private static final String NULL_MESSAGE = "null이 입력되면 안됩니다";
    private final List<String> names;

    public NameSplitter(String names) {
        validateNames(names);
        this.names = Arrays.stream(names.split(","))
                .collect(Collectors.toList());
    }

    private void validateNames(String names) {
        if (names == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }

    public List<String> split() {
        return names;
    }
}
