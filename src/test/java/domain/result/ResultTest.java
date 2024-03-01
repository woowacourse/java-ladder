package domain.result;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ResultTest {
    @ParameterizedTest
    @ValueSource(strings = {""," ","    "})
    @DisplayName("결과의 이름이 비어 있으면 예외가 발생한다")
    void emptyName(String name) {
        assertThatCode(() -> new Result(name)).isInstanceOf(IllegalArgumentException.class);
    }
}
