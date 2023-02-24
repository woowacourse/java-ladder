package domain;

import domain.player.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

    @Nested
    @DisplayName("포지션 생성 테스트")
    class createPositionTest {
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 3})
        void 포지션_생성_값_입력(int input) {
            Position position = new Position(input);
            Assertions.assertEquals(position.getValue(), input);
        }
    }
}
