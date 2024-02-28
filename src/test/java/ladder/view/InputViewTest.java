package ladder.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
    @Nested
    @DisplayName("사용자 이름 입력 시")
    class inputUserNames {
        @DisplayName(",로 구분하여 이름을 입력하면 List<String>로 반환한다.")
        @Test
        void parseNamesWithDelimiter() {
            List<String> names = InputView.readNames(() -> "a,b,c");
            assertThat(names).containsExactly("a", "b", "c");
        }

        @DisplayName("사용자 이름으로 공백이 입력되면 예외를 던진다.")
        @NullAndEmptySource
        @ValueSource(strings = {" ", "  ", "\t", "\n"})
        @ParameterizedTest
        void validateNamesWithNullOrEmpty(final String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> InputView.readNames(() -> input))
                    .withMessage("공백을 넣을 수 없습니다.");
        }
    }

    @Nested
    @DisplayName("실행 결과 입력 시")
    class inputDestinations {
        @DisplayName(",로 구분하여 실행 결과를 입력하면 List<String>로 반환한다.")
        @Test
        void parseNamesWithDelimiter() {
            List<String> destinations = InputView.readDestinations(() -> "꽝,5000,4000,꽝");
            assertThat(destinations).containsExactly("꽝", "5000", "4000", "꽝");
        }

        @DisplayName("공백이 입력되면 예외를 던진다.")
        @NullAndEmptySource
        @ValueSource(strings = {" ", "  ", "\t", "\n"})
        @ParameterizedTest
        void validateDestinationsWithNullOrEmpty(String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> InputView.readDestinations(() -> input))
                    .withMessage("공백을 넣을 수 없습니다.");
        }
    }

    @Nested
    @DisplayName("사다리 높이 입력 시")
    class inputLadderHeight {
        @DisplayName("사다리 높이에 공백이 입력되면 예외를 던진다.")
        @NullAndEmptySource
        @ValueSource(strings = {" ", "  ", "\t", "\n"})
        @ParameterizedTest
        void validateLadderHeightWithNullOrEmpty(final String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> InputView.readLadderHeight(() -> input))
                    .withMessage("공백을 넣을 수 없습니다.");
        }

        @DisplayName("사다리 높이에 숫자가 아닌 값이 들어오면 예외를 던진다.")
        @ValueSource(strings = {"a", "!"})
        @ParameterizedTest
        void readLadderHeightByNotNumber(final String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> InputView.readLadderHeight(() -> input))
                    .withMessage("사다리 높이에는 숫자를 입력해야 합니다");
        }
    }

    @Nested
    @DisplayName("결과 보고 싶은 사람 입력 시")
    class inputRequestResult {
        @DisplayName("공백이 입력되면 예외를 던진다.")
        @NullAndEmptySource
        @ValueSource(strings = {" ", "  ", "\t", "\n"})
        @ParameterizedTest
        void validateRequestResultWithNullOrEmpty(final String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> InputView.readRequestName(() -> input))
                    .withMessage("공백을 넣을 수 없습니다.");
        }
    }
}
