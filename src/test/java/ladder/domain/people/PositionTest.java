package ladder.domain.people;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position(0);
    }

    @DisplayName("movePosition()은 받은 인자 만큼 포지션을 이동시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void test_1(int direct) {
        // given & when
        position.movePosition(direct);

        // then
        Assertions.assertThat(position.getPosition()).isEqualTo(direct);
    }
}
