package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    @DisplayName("사다리를 올바르게 생성한다.")
    void ladderCreationTest(int height) {
        assertDoesNotThrow(() -> Ladder.of(5, height));
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 11})
    @DisplayName("사다리의 높이가 1 이상 10 이하가 아닌 경우 예외를 발생시킨다.")
    void ladderCreationTestWithInvalidHeight(int height) {
        assertThatThrownBy(() -> Ladder.of(5, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 1 이상 10 이하여야 합니다.");
    }
}
