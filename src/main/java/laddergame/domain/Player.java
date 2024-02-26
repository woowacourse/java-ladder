package laddergame.domain;

import java.util.Objects;
import laddergame.view.ReservedWords;

public class Player {
    private static final int NAME_MAX_LENGTH = 5;
    private static final String NAME_LENGTH_ERROR = String.format("이름 길이는 최대 %s자만 허용합니다.", NAME_MAX_LENGTH);
    public static final String NAME_BLANK_ERROR = "빈 이름은 허용하지 않습니다.";
    private static final String RESERVED_WORD_ERROR = "이름은 예약어로 지을 수 없습니다. 입력된 이름은 %s입니다.";
    private final String name;

    public Player(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        checkNameIsBlank(name);
        checkNameLength(name);
        checkReservedWords(name);
    }

    private void checkReservedWords(final String name) {
        if (ReservedWords.isIncluded(name)) {
            throw new IllegalArgumentException(RESERVED_WORD_ERROR);
        }
    }

    private void checkNameLength(final String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(NAME_LENGTH_ERROR, name));
        }
    }

    private void checkNameIsBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NAME_BLANK_ERROR);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Player player = (Player) o;

        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
