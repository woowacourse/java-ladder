package model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @DisplayName("음수가 아니면 예외를 던지지 않는다.")
    @Test
    void notNegativePosition() {
        assertAll(() -> assertThatCode(Position::new).doesNotThrowAnyException(),
                () -> assertThatCode(() -> new Position(1)).doesNotThrowAnyException());
    }

    @DisplayName("음수면 예외를 던진다.")
    @Test
    void negativePositionThrowException() {
        Assertions.assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자의 위치는 음수가 될 수 없습니다.");
    }

    @DisplayName("같은 값을 가지면 동일하다.")
    @Test
    void SameValue() {
        Assertions.assertThat(new Position(1)).isEqualTo(new Position(1));
    }

    //TODO: 예외처리: position이 0보다 작다면? List<Line>의 크기보다 크다면?
    @DisplayName("값을 1 증가시킨다.")
    @Test
    void increment() {
        Assertions.assertThat(new Position(1).increment()).isEqualTo(new Position(2));
    }

    @DisplayName("값을 1 감소시킨다.")
    @Test
    void decrement() {
        Assertions.assertThat(new Position(1).decrement()).isEqualTo(new Position(0));
    }
}
