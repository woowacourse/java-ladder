package domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @DisplayName("위치값 생성하기")
    @Test
    void create_position() {
        assertDoesNotThrow(() -> new Position(0));
    }

    @DisplayName("왼쪽으로 가기")
    @Test
    void move_left() {
        Position position = new Position(1);
        position.moveLeft();
        Position result = new Position(0);

        assertThat(position).usingRecursiveComparison().isEqualTo(result);
    }

    @DisplayName("오른쪽으로 가기")
    @Test
    void move_right() {
        Position position = new Position(0);
        position.moveRight();
        Position result = new Position(1);

        assertThat(position).usingRecursiveComparison().isEqualTo(result);
    }

}
