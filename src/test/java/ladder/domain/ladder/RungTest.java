package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RungTest {

    @Test
    @DisplayName("발판은 상태(존재한다, 존재하지 않는다)를 가진다.")
    void testRung() {
        Rung[] rungs = Rung.values();
        assertThat(rungs).containsExactly(Rung.EXIST, Rung.EMPTY);
    }
}
