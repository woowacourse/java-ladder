package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BetTest {

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
}
