package domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum LineState {
    MOVABLE_STATE(1, true),
    UNMOVABLE_STATE(0, false);

    private static final String CAN_NOT_FIND_STATE_FROM_VALUE_MESSAGE = "%d에 해당되는 상태값이 존재하지 않습니다.";

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
            throw new IllegalArgumentException(
                    String.format(CAN_NOT_FIND_STATE_FROM_VALUE_MESSAGE ,value));
        }
    }

}
