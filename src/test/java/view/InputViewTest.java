package view;

import domain.Height;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class InputViewTest {
    @DisplayName("이름에 대한 입력 테스트")
    @Nested
    class NameTest {

        @DisplayName("interface Reader로부터 받은 String을 List<String>으로 반환한다.")
        @Test
        void stringToListTest() {
            Assertions.assertThat(InputView.readNames(() -> "a,b,c"))
                    .isEqualTo(List.of("a", "b", "c"));
        }

        @DisplayName("null 혹은 빈 문자열을 받으면 예외를 발생한다.")
        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {" ", "\t", "\n"})
        void emptyInputTest(String input) {
            Assertions.assertThatThrownBy(() -> InputView.readNames(() -> input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("null 혹은 빈 문자열을 입력할 수 없습니다.");
        }

        @DisplayName("쉼표로 구분된 이름이 null 혹은 빈 문자열이면 예외를 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {",b,c", "a,,c", "a,b,"})
        void emptyNameTest(String input) {
            Assertions.assertThatThrownBy(() -> InputView.readNames(() -> input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("null 혹은 빈 문자열을 입력할 수 없습니다.");
        }

        @DisplayName("공백을 제거한 이름을 반환한다.")
        @Test
        void nameWithSpacesTest() {
            Assertions.assertThat(InputView.readNames(() -> "a , b , c"))
                    .isEqualTo(List.of("a", "b", "c"));
        }
    }

    @DisplayName("사다리 높이에 대한 입력 테스트")
    @Nested
    class HeightTest {
        @DisplayName("null 혹은 빈 문자열을 받으면 예외를 발생한다.")
        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {" ", "\t", "\n"})
        void emptyInputTest(String input) {
            Assertions.assertThatThrownBy(() -> InputView.readHeight(() -> input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("null 혹은 빈 문자열을 입력할 수 없습니다.");
        }

        @DisplayName("입력받은 height를 정수로 반환한다.")
        @Test
        void stringToIntegerTest() {
            Assertions.assertThat(InputView.readHeight(() -> "5"))
                    .isEqualTo(new Height(5));
        }

        @DisplayName("숫자 외의 값을 입력받으면 예외를 발생한다.")
        @Test
        void notNumberTest() {
            Assertions.assertThatThrownBy(() -> InputView.readHeight(() -> "무빈"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("정수를 입력해야 합니다.");
        }
    }

    @DisplayName("실행결과에 대한 입력 테스트")
    @Nested
    class winningsTest {
        @DisplayName("interface Reader로부터 받은 String을 List<String>으로 반환한다.")
        @Test
        void stringToListTest() {
            Assertions.assertThat(InputView.readWinnings(() -> "a,b,c"))
                    .isEqualTo(List.of("a", "b", "c"));
        }
    }
}