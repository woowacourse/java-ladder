package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class RungTest {
    @ParameterizedTest
    @EnumSource(Rung.class)
    @DisplayName("발판은 상태를 가진다.")
    void testRungStatus(Rung rung) {
        Rung[] values = Rung.values();
        assertThat(values).contains(rung);
    }

}
