package view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderHeightInputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"2", "20"})
    @DisplayName("정상적인 사다리 높이가 입력된 경우")
    void getLadderHeight(String input) {
        int ladderHeight = LadderHeightInputView.getLadderHeight(input);
        Assertions.assertThat(ladderHeight)
                .isEqualTo(Integer.valueOf(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ㅁ2", "a", " 2", "2 ", "a", "A"})
    @DisplayName("숫자가 아닌게 입력된 경우")
    void validateLadderHeight(String input) {
        Assertions.assertThatThrownBy(() -> LadderHeightInputView.getLadderHeight(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닙니다.");
    }
}
