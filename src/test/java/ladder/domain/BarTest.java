package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BarTest {

    @ParameterizedTest(name = "inputValue={0}, expected={1}" )
    @CsvSource(value = {"true, true", "false, false"})
    @DisplayName("인자로 전달된 boolean에 해당하는 enum 상수가 반환되는지 확인한다")
    void BarInitiatorTest(boolean inputValue, boolean expected) {
        assertThat(Bar.getBar(inputValue).getValue())
                .isEqualTo(expected);
    }

}
