package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StepTest {
    @ParameterizedTest
    @CsvSource({"true,Y", "false,N"})
    public void Foothold_생성(boolean state, Step expected) {
        assertThat(Step.from(state)).isEqualTo(expected);
    }
}
