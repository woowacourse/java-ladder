package ladder.domain;

import java.util.*;

public class Player {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_NANE_LENGTH = 1;
    private static final String FORBIDDEN_NAME = "all";

    private final String name;
    private int position;

    Player(final String name) {
        this(name, 0);
    }

    Player(String name, int position) {
        nullCheck(name);
        this.name = getTrimmed(name);
        this.position = position;
    }

    private void nullCheck(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름에는 null이 입력될 수 없습니다.");
        }
    }

    private String getTrimmed(String name) {
        name = name.trim();
        validateCommandName(name);
        validateNameLength(name);
        return name;
    }

    private void validateCommandName(String name) {
        if (name.equals(FORBIDDEN_NAME)) {
            throw new IllegalArgumentException("이름에는 all이 입력될 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if ((name.length() > MAXIMUM_NAME_LENGTH) || (name.length() < MINIMUM_NANE_LENGTH)) {
            throw new IllegalArgumentException("이름의 길이는 1자 이상, 5자 이하여야 합니다.");
        }
    }

    Map<String, ResultItem> stepDown(Ladder ladder) {
        Map<String, ResultItem> ladderingResult = new LinkedHashMap<>();

        ladderingResult.put(name, ladder.answerResult(position));
        return ladderingResult;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
