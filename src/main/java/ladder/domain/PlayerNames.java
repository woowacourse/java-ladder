package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerNames {

    private static final String LENGTH_EXCEPTION_MESSAGE = "[ERROR] 참여자의 이름은 1자 이상 5자 이하여야 합니다.";

    private final List<String> names;

    public PlayerNames(final List<String> names) {
        validate(names);
        this.names = new ArrayList<>(names);
    }

    private void validate(final List<String> names) {
        validateLength(names);
    }

    private void validateLength(final List<String> names) {
        if(isWrongLength(names)) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private boolean isWrongLength(final List<String> names) {
        long count = names.stream()
                .filter(name -> name.length() < 1 || name.length() > 5)
                .count();
        return count != 0;
    }
}
