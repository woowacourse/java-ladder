package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LadderPropertyTest {

    @ParameterizedTest
    @CsvSource(value = {"3, 5", "4, 6", "10, 20"})
    @DisplayName("사다리의 너비와 높이를 받아서 사다리 속성을 생성한다.")
    void generateLadderProperty(int width, int height) {
        Assertions.assertDoesNotThrow(() -> new LadderProperty(width, height));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1001, 10000})
    @DisplayName("높이가 1 미만이거나 1000 초과이면 예외를 던진다.")
    void heightRangeTest(int height) {

        assertThatThrownBy(() -> new LadderProperty(3, height))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[ERROR] 사다리의 높이는 1 이상 1000 이하여야합니다.");
    }
}
