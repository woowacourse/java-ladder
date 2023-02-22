package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BetTest {

    @DisplayName("내기 항목은 5자 이내여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"aaaaa", "bbbbbbbb", "cdefese"})
    void createBetFailTest(String bet) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Bet(bet));
    }
}
