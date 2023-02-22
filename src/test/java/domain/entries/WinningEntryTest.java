package domain.entries;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningEntryTest {

    @DisplayName("당첨 항목은 5글자를 초과할 수 없다.")
    @Test
    void winningEntryNotMoreThan5() {
        assertThatThrownBy(() -> new WinningEntry("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 항목은 최대 5글자까지 가능합니다.");
    }

    @DisplayName("당첨 항목은 빈 문자열일 수 없다.")
    @Test
    void winningEntryNotBlank() {
        assertThatThrownBy(() -> new WinningEntry(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 항목은 공백일 수 없습니다.");
    }

    @DisplayName("당첨 항목은 1글자 이상 5글자 이하이다.")
    @ValueSource(strings = {"a", "abcde"})
    @ParameterizedTest
    void correctWinningEntryLength(String winningEntry) {
        assertThatNoException()
                .isThrownBy(() -> new WinningEntry(winningEntry));
    }

}
