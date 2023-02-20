package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author 베베
 * @version 1.0.0
 * @Created by 베베 on 2023. 02. 18.
 */
public class LinesTest {

    @DisplayName("사다리 라인들을 생성할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = "3:5", delimiter = ':')
    void 사다리_높이만큼_라인_생성(int personCount, int height) {
        Lines lines = new Lines(personCount, height);
        Assertions.assertThat(lines.getLines().size()).isEqualTo(height);
    }
}
