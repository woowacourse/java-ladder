package view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Name;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @Test
    @DisplayName("입력을 구분자로 올바르게 구분한다.")
    void splitInputTest() {
        // given
        InputView inputView = new InputView(() -> "a,b,c,d");
        // when
        List<Name> actual = inputView.readNames();
        List<Name> expected = Stream.of("a", "b", "c", "d")
                .map(Name::new)
                .toList();
        // then
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"a", "3.4", "' '", "NULL"}, nullValues = {"NULL"})
    @DisplayName("올바르지 않은 사다리 높이가 입력되면, 예외를 발생한다.")
    void invalidLadderHeightInputTest(String input) {
        // given
        InputView inputView = new InputView(() -> input);
        // when & then
        assertThatThrownBy(inputView::readLadderHeight)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 1 이상 10 이하의 정수여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"})
    @DisplayName("올바른 사다리 높이가 입력되면, 정수로 반환한다.")
    void validLadderHeightInputTest(String input) {
        // given
        InputView inputView = new InputView(() -> input);
        // when
        int actual = inputView.readLadderHeight().value();
        int expected = Integer.parseInt(input);
        // then
        assertThat(actual).isEqualTo(expected);
    }
}
