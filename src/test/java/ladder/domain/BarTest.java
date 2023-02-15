package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BarTest {

    @ParameterizedTest
    @CsvSource(value = {"true, true", "false, false"})
    @DisplayName("인자로 전달된 boolean 값이 제대로 저장되었는지 확인한다")
    void BarInitiatorTest(boolean inputValue, boolean expected) {
        assertThat(new Bar(inputValue).getValue())
                .isEqualTo(expected);
    }

}
