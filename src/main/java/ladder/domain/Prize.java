package ladder.domain;

import java.util.Set;
import java.util.stream.Collectors;

public class Prize {
    private final String name;

    public Prize(String name) {
        validateBlank(name);
        this.name = name;
    }

    private void validateBlank(String name) {
        Set<Character> chars = name.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
        if (chars.size() == 1 && chars.contains(' ')) {
            throw new IllegalArgumentException("상품명은 공백으로만 이루어질 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
