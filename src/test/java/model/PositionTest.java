package model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    void PositivePositionNotThrowException() {
        assertAll(
                () -> assertThatCode(Position::new).doesNotThrowAnyException(),
                () -> assertThatCode(() -> new Position(1)).doesNotThrowAnyException()
        );
    }

    @Test
    void NotPositivePositionThrowException() {
        Assertions.assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("참가자의 위치는 음수가 될 수 없습니다.");
    }

    class Position {
        private final int value;

        Position() {
            this(0);
        }

        Position(int value) {
            this.value = value;
        }
    }
}
