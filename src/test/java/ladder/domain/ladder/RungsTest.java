package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RungsTest {
    @Test
    @DisplayName("연결된 인덱스를 찾는다.")
    void findConnectedIndex() {
        Rungs rungs = new Rungs(List.of(Rung.of(true)));

        assertThat(rungs.findConnectedIndex(0)).isEqualTo(1);
    }
}
