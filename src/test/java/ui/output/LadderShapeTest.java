package ui.output;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderShapeTest {

    @DisplayName("사다리 모양을 반환해야 한다.")
    @Test
    void returnLadderShape() {
        // given
        List<Boolean> points = List.of(true, false, false);
        StringBuilder ladderForm = LadderShape.getLadderForm(points, 5);
        assertThat(ladderForm.toString()).isEqualTo("    |-----|     |     |");
    }
}