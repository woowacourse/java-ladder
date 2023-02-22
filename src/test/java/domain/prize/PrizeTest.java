package domain.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizeTest {

    @DisplayName("당첨 항목은 5글자를 초과할 수 없다.")
    @Test
    void prizeNotMoreThan5() {
        assertThatThrownBy(() -> new Prize("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 항목은 최대 5글자까지 가능합니다.");
    }

    @DisplayName("당첨 항목은 빈 문자열일 수 없다.")
    @Test
    void prizeNotBlank() {
        assertThatThrownBy(() -> new Prize(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 항목은 공백일 수 없습니다.");
    }

    @DisplayName("당첨 항목은 1글자 이상 5글자 이하이다.")
    @ValueSource(strings = {"a", "abcde"})
    @ParameterizedTest
    void correctPrizeLength(String prize) {
        assertThatNoException()
                .isThrownBy(() -> new Prize(prize));
    }

}
