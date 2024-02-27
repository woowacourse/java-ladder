package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RungTest {
    @ParameterizedTest
    @CsvSource(value = {"true:EXIST", "false:EMPTY"}, delimiter = ':')
    @DisplayName("발판은 상태를 가진다.")
    void testCreateRung(boolean exist, Rung rung) {
        assertThat(Rung.of(exist)).isEqualTo(rung);
    }

    @Test
    @DisplayName("발판은 존재한다.")
    void testRungExist() {
        assertThat(Rung.of(true).isExist()).isTrue();
    }

    @Test
    @DisplayName("발판은 존재하지 않는다.")
    void testRungEmpty() {
        assertThat(Rung.of(false).isEmpty()).isTrue();
    }
}
