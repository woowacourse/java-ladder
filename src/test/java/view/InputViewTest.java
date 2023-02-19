package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사용자로부터 ")
class InputViewTest {
    @Nested
    @DisplayName("입력받은 참가자들의 이름이")
    class NamesCase {
        @Test
        @DisplayName("쉼표로 구분된 이름이 아니면 예외가 발생한다.")
        void givenNamesNotSeparatedByComma_thenThrowsException() {
            String names = "하마.고양이.강아지";

            assertThatThrownBy(getInputView(names)::getNames)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(InputView.SEPARATOR_REQUIRED_ERROR_MESSAGE);
        }

        @Test
        @DisplayName("쉼표로 구분된 이름이면, 쉼표를 기준으로 이름을 분리해 저장한다.")
        void givenNamesSeparatedByComma_thenReturnsSeparated() {
            String names = "하마,고양이,강아지";

            assertThat(getInputView(names).getNames())
                    .containsExactly("하마", "고양이", "강아지");
        }

        @Test
        @DisplayName("쉼표 이후 공백이 포함되어 있다면, 이름을 분리한 후 공백을 제거해 저장한다.")
        void givenNamesSeparatedByCommaWithSpace_thenReturnSeparatedWithoutSpace() {
            String names = "하마, 고양이, 강아지";

            assertThat(getInputView(names).getNames())
                    .containsExactly("하마", "고양이", "강아지");
        }
    }

    @Nested
    @DisplayName("입력받은 사다리 높이가 ")
    class HeightCase {
        @Test
        @DisplayName("양수의 정수라면 int 값을 반환받는다.")
        void givenHeight_thenReturnsHeight() {
            String height = "5";

            assertThat(getInputView(height).getHeight())
                    .isEqualTo(5);
        }

        @Test
        @DisplayName("정수가 아니면 예외가 발생한다.")
        void givenNotInteger_thenThrowsException() {
            String height = "다섯층";

            assertThatThrownBy(() -> getInputView(height).getHeight())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(InputView.INTEGER_ERROR_MESSAGE);
        }

        @Test
        @DisplayName("양수의 정수가 아니면 예외가 발생한다.")
        void givenNotPositiveInteger_thenThrowsException() {
            String height = "-1";

            assertThatThrownBy(() -> getInputView(height).getHeight())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(InputView.POSITIVE_INTEGER_ERROR_MESSAGE);
        }
    }

    private static InputView getInputView(String... names) {
        return new InputView(new MockInputReader(names));
    }
}