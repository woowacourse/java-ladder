package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderPropertyTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1001, 10000})
    @DisplayName("높이가 1 미만이거나 1000 초과이면 예외를 던진다.")
    void heightRangeTest(int height) {

        assertThatThrownBy(() -> new LadderProperty(3, height))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[ERROR] 사다리의 높이는 1 이상 1000 이하여야합니다.");
    }

}
