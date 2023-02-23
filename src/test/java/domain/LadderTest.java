package domain;

import helper.StubPossiblePointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("높이에 0이하의 값을 입력하면 예외 발생")
    void validateHeight(int height) {
        assertThatThrownBy(() -> new Ladder(height, 4, new RandomPointGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Ladder.INVALID_HEIGHT_ERROR);
    }

    @Test
    @DisplayName("사다리가 제대로(왼쪽, 오른쪽, 직진) 작동해 최종 위치를 반환하는지 확인")
    void getLast() {
        int startPosition = 0;
        int lastPosition = 1;
        Ladder ladder = new Ladder(5, 4, new StubPossiblePointGenerator());

        assertThat(ladder.getLastPosition(startPosition))
                .isEqualTo(lastPosition);
    }
}
