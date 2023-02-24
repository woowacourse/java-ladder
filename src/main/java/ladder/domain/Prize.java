package ladder.domain;

import java.util.Set;
import java.util.stream.Collectors;

public class Prize {
    private static final String NAME_BLANK_ERROR_MESSAGE = "상품명은 공백으로만 이루어질 수 없습니다.";
    private final String name;

    public Prize(String name) {
        validateOnlyBlank(name);
        this.name = name;
    }

    private void validateOnlyBlank(String name) {
        Set<Character> chars = name.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
        if (chars.size() == 1 && chars.contains(' ')) {
            throw new IllegalArgumentException(NAME_BLANK_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
