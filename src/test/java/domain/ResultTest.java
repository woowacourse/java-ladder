package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @DisplayName("값은 1~5자 사이여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    void checkValueLength(String value) {
        Result result = new Result(value);

        assertThat(result.getValue()).isEqualTo(value);
    }
}
