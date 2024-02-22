package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0",})
    @DisplayName("높이는 양의 정수만 가능하다.")
    void isPositiveIntegerTest(String number) {

        assertThatThrownBy(() -> new Height(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 높이가 정해진 규칙에 맞지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"&", "op%la",})
    @DisplayName("높이는 숫자로 변환이 가능해야 함을 테스트")
    void isCanTranslateToIntegerTest(String input) {

        assertThatThrownBy(() -> new Height(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("숫자로 입력을 변환할 수 없습니다.");
    }
}
