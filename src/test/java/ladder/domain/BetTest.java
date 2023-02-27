package ladder.domain;

import ladder.error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BetTest {

    @ParameterizedTest(name = "내기 항목은 쉼표를 제외한 1자 이상, 5자 이하로 생성할 수 있다.")
    @ValueSource(strings = {"a", "a@a", "aa aa"})
    void createBetSuccessTest(String bet) {
        assertDoesNotThrow(() -> new Bet(bet));
    }

    @ParameterizedTest(name = "내기 항목은 5자 이하여야 한다.")
    @ValueSource(strings = {"aaaaaa", "bbbbbbbb", "cdefese"})
    void createBetFailTestByLength(String bet) {
        assertThatThrownBy(() -> new Bet(bet))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_BET_LENGTH.getMessage());
    }

    @DisplayName("내기 항목은 null일 수 없다.")
    @Test
    void createBetFailTestByNullValue() {
        assertThatThrownBy(() -> new Bet(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage(ErrorMessage.BET_IS_NULL.getMessage());
    }

    @DisplayName("내기 항목은 비어있을 수 없다.")
    @Test
    void createBetFailTestByEmptyValue() {
        assertThatThrownBy(() -> new Bet(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_BET_LENGTH.getMessage());
    }

    @ParameterizedTest(name = "내기 항목은 쉼표(,)를 포함할 수 없다.")
    @ValueSource(strings = {"a,b", "bbb,b", ","})
    void createBetFailTestByComma(String bet) {
        assertThatThrownBy(() -> new Bet(bet))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_BET_FORMAT.getMessage());
    }

    @ParameterizedTest(name = "내기 항목은 공백을 포함할 수 있다.")
    @ValueSource(strings = {"a b", "ccc c"})
    void createBetSuccessTestByContainingSpace(String bet) {
        assertDoesNotThrow(() -> new Bet(bet));
    }

    @ParameterizedTest(name = "내기 항목은 쉼표(,)를 제외한 특수문자를 포함할 수 있다.")
    @ValueSource(strings = {"@@@@", "a@b@c"})
    void createBetSuccessTestBySpecialCharactersWithoutComma(String bet) {
        assertDoesNotThrow(() -> new Bet(bet));
    }
}
