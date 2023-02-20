package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ResultsTest {

    @DisplayName("실행 결과의 수는 사람 수와 일치해야 한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "꽝,5000:2",
            "꽝,5000,꽝:3",
            "꽝,5000,꽝,3000:4",
    }, delimiter = ':')
    void success(String input, int personCount) {
        assertDoesNotThrow(() -> new Results(input, personCount));
    }

    @DisplayName("실행 결과의 수가 일치하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "꽝,5000:3",
            "꽝,5000,꽝:4",
            "꽝,5000,꽝,3000:3",
    }, delimiter = ':')
    void fail(String input, int personCount) {
        assertThatThrownBy(() -> new Results(input, personCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과의 수는 사람 수와 같아야 합니다");
    }
}
