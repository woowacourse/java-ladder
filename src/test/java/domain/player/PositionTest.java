package domain.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

    @DisplayName("정수를 입력해 포지션을 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void createPositionTest(int input) {
        Position position = new Position(input);
        Assertions.assertEquals(position.getValue(), input);
    }
}
