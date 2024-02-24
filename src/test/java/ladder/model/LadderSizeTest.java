package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderSizeTest {
    @ParameterizedTest
    @CsvSource({
            "0, 5",
            "5, 0"
    })
    @DisplayName("사다리 크기가 자연수가 아니면 예외가 발생한다.")
    void ladderHeightRangeTest() {
        int height = 0;
        int width = 5;
        assertThatThrownBy(() -> new LadderSize(height, width))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 크기는 자연수여야 합니다.");
    }
}
