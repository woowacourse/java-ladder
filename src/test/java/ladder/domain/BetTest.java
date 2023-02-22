package ladder.domain;

import ladder.error.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BetTest {

    @ParameterizedTest(name = "내기 항목은 쉼표를 제외한 1자 이상, 5자 이하로 생성할 수 있다.")
    @ValueSource(strings = {"a", "a@a", "aa aa"})
    void createBetSuccessTest(String bet) {
        Assertions.assertDoesNotThrow(() -> new Bet(bet));
    }

    @ParameterizedTest(name = "내기 항목은 5자 이하여야 한다.")
    @ValueSource(strings = {"aaaaaa", "bbbbbbbb", "cdefese"})
    void createBetFailTestByLength(String bet) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Bet(bet));
        Assertions.assertEquals(ErrorMessage.INVALID_BET_LENGTH.getMessage(), exception.getMessage());
    }

    @DisplayName("내기 항목은 null일 수 없다.")
    @Test
    void createBetFailTestByNullValue() {
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> new Bet(null));
        Assertions.assertEquals(ErrorMessage.BET_IS_NULL.getMessage(), exception.getMessage());
    }

    @DisplayName("내기 항목은 비어있을 수 없다.")
    @Test
    void createBetFailTestByEmptyValue() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Bet(""));
        assertEquals(ErrorMessage.INVALID_BET_LENGTH.getMessage(), exception.getMessage());
    }

    @ParameterizedTest(name = "내기 항목은 쉼표(,)를 포함할 수 없다.")
    @ValueSource(strings = {"a,b", "bbb,b", ","})
    void createBetFailTestByComma(String bet) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Bet(bet));
        assertEquals(ErrorMessage.INVALID_BET_FORMAT.getMessage(), exception.getMessage());
    }

    @ParameterizedTest(name = "내기 항목은 공백을 포함할 수 있다.")
    @ValueSource(strings = {"a b", "ccc c"})
    void createBetSuccessTestByContainingSpace(String bet) {
        Assertions.assertDoesNotThrow(() -> new Bet(bet));
    }

    @ParameterizedTest(name = "내기 항목은 쉼표(,)를 제외한 특수문자를 포함할 수 있다.")
    @ValueSource(strings = {"@@@@", "a@b@c"})
    void createBetSuccessTestBySpecialCharactersWithoutComma(String bet) {
        Assertions.assertDoesNotThrow(() -> new Bet(bet));
    }
}
