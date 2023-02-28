package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Position은 ")
public class PositionTest {

    private Position position;
    private int initialValue;

    @BeforeEach
    void setUp() {
        initialValue = 5;
        position = new Position(initialValue);
    }

    @DisplayName("moveLeft메서드를 실행했을 때, 값이 1만큼 감소한 Position을 반환한다.")
    @Test
    void decrease_value_when_move_left() {
        // when
        Position decreasedPosition = position.moveLeft();

        // then
        assertThat(decreasedPosition.getValue()).isEqualTo(initialValue - 1);
    }

    @DisplayName("moveRight메서드를 실행했을 때, 값이 1만큼 증가한 Position을 반환한다.")
    @Test
    void increase_value_when_move_right() {
        // when
        Position increasedPosition = position.moveRight();

        // then
        assertThat(increasedPosition.getValue()).isEqualTo(initialValue + 1);
    }
}
