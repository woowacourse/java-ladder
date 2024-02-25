package view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    InputView createInputViewWithModifiedInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        return new InputView();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "3.4"})
    @DisplayName("올바르지 않은 사다리 높이가 입력되면, 예외를 발생한다.")
    void invalidLadderHeightInputTest(String input) {
        // given
        InputView inputView = createInputViewWithModifiedInput(input);
        // when & then
        assertThatThrownBy(inputView::readLadderHeight)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 정수로 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "9", "10"})
    @DisplayName("올바른 사다리 높이가 입력되면, 정수로 반환한다.")
    void validLadderHeightInputTest(String input) {
        // given
        InputView inputView = createInputViewWithModifiedInput(input);
        // when
        int actual = inputView.readLadderHeight();
        int expected = Integer.parseInt(input);
        // then
        assertThat(actual).isEqualTo(expected);
    }
}
