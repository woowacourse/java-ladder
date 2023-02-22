package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BetTest {

    // TODO: 2023-02-22 에러 메세지 검증 구현
    // TODO: 2023-02-22 DisplayName -> ParameterizedTest name으로 변경
    @DisplayName("내기 항목은 쉼표를 제외한 1자 이상, 5자 이하로 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "a@a", "aa aa"})
    void createBetSuccessTest(String bet) {
        Assertions.assertDoesNotThrow(() -> new Bet(bet));
    }

    @DisplayName("내기 항목은 5자 이하여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa", "bbbbbbbb", "cdefese"})
    void createBetFailTestByLength(String bet) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Bet(bet));
    }

    @DisplayName("내기 항목은 null일 수 없다.")
    @Test
    void createBetFailTestByNullValue() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Bet(null));
    }

    @DisplayName("내기 항목은 비어있을 수 없다.")
    @Test
    void createBetFailTestByEmptyValue() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Bet(""));
    }

    @DisplayName("내기 항목은 쉼표(,)를 포함할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"a,b", "bbb,b", ","})
    void createBetFailTestByComma(String bet) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Bet(bet));
    }

    @DisplayName("내기 항목은 공백을 포함할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"a b", "ccc c"})
    void createBetSuccessTestByContainingSpace(String bet) {
        Assertions.assertDoesNotThrow(() -> new Bet(bet));
    }

    @DisplayName("내기 항목은 쉼표(,)를 제외한 특수문자를 포함할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"@@@@", "a@b@c"})
    void createBetSuccessTestBySpecialCharactersWithoutComma(String bet) {
        Assertions.assertDoesNotThrow(() -> new Bet(bet));
    }
}
