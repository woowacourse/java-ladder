package domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum LineState {
    MOVABLE_STATE(1, true),
    UNMOVABLE_STATE(0, false);

    private final int value;
    private final boolean state;

    LineState(int value, boolean state) {
        this.value = value;
        this.state = state;
    }

    public boolean getState() {
        return state;
    }

    public static LineState of(int value) {
        try {
            return Arrays.stream(LineState.values())
                    .filter(s -> s.value == value)
                    .findAny()
                    .get();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 오류 발생 ");
        }
    }

}
