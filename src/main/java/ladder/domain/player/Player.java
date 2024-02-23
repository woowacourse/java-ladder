package ladder.domain.player;

import java.util.Objects;
import java.util.regex.Pattern;

public class Player {
    private static final int MAXIMUM_NAME_RANGE = 5;
    private static final Pattern NAME_VALID_FORMAT = Pattern.compile("[ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]+");

    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNameRange(name);
        validateNameFormat(name);
    }

    private void validateNameRange(String name) {
        if (name.isBlank() || name.length() > MAXIMUM_NAME_RANGE) {
            throw new IllegalArgumentException(String.format("참가자의 이름은 1~%d글자이어야 합니다.", MAXIMUM_NAME_RANGE));
        }
    }

    private void validateNameFormat(String name) {
        if (!NAME_VALID_FORMAT.matcher(name).matches()) {
            throw new IllegalArgumentException("참가자들의 이름은 한글, 영어, 숫자여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
