package laddergame.ladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FootholdTest {
    @ParameterizedTest
    @CsvSource({"true,PASSABLE", "false,BLOCKED"})
    public void Foothold_생성(boolean state, Foothold expected) {
        assertThat(Foothold.from(state)).isEqualTo(expected);
    }
}
