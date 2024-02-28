package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.LinesTest.FixedPointGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoverTest {
    @Test
    @DisplayName("사다리 이동 결과를 반환한다.")
    void getMoveResult() {
        Lines lines = new Lines(2, 2, new FixedPointGenerator());
        Names names = new Names(List.of("pobi", "crong"));
        Mover mover = new Mover(lines, names);

        List<String> moveResult = mover.getMoveResult();

        assertThat(moveResult).containsExactly("pobi", "crong");
    }
}
