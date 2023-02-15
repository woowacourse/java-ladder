package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FootholdTest {
    @ParameterizedTest
    @CsvSource({"true,Y", "false,N"})
    public void Foothold_생성(boolean state, Foothold expected){
        assertThat(Foothold.from(state)).isEqualTo(expected);
    }
}