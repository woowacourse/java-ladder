package ladder.domain;

import java.util.*;

public class Player extends LadderItem {
    private static final String FORBIDDEN_NAME = "all";
    private static final int DEFAULT_POSITION = 0;

    private int position;

    Player(final String name) {
        this(name, DEFAULT_POSITION);
    }

    Player(String name, int position) {
        super(name);
        validateCommandName(name);
        this.position = position;
    }

    private void validateCommandName(String name) {
        if (name.equals(FORBIDDEN_NAME)) {
            throw new IllegalArgumentException("플레이어 이름에는 all이 입력될 수 없습니다.");
        }
    }

    Map<String, ResultItem> stepDown(Ladder ladder) {
        Map<String, ResultItem> ladderingResult = new LinkedHashMap<>();

        ladderingResult.put(getName(), ladder.answerResult(position));
        return ladderingResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Player player = (Player) o;
        return position == player.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), position);
    }
}
