package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LinesTest {

    @DisplayName("사다리 라인들을 생성할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = "3:5", delimiter = ':')
    void 사다리_높이만큼_라인_생성(int personCount, int height) {
        Lines lines = new Lines(personCount, height);
        Assertions.assertThat(lines.getLineHeight()).isEqualTo(height);
    }

    @DisplayName("사다리 높이의 입력 타입은 0을 포함하지 않는 자연수여야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void validateInputLadderHeight(int height) {
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> new Lines(2, height));
    }
}
