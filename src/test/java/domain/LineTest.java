package domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LineTest {

    @ParameterizedTest(name = "true라면 EXIST, false라면 NOT_EXIST를 반환한다. 입력값 = {0}, 결과값 = {1}")
    @CsvSource({"true,EXIST", "false,NOT_EXIST"})
    void should_returnLineValueAppropriately(boolean isExist, Line line) {
        assertThat(Line.from(isExist)).isEqualTo(line);
    }
}
