package ui.output;

import domain.Lines;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 베베
 * @version 1.0.0
 * @Created by 베베 on 2023. 02. 20.
 */
class LadderShapeTest {

    @DisplayName("사다리 모양을 반환해야 한다.")
    @Test
    void returnLadderShape() {
        // given
        List<Boolean> points = List.of(true, false, false, true)
        String ladderForm = LadderShape.getLadderForm(points, 5);
        assertThat(ladderForm).isEqualTo("----|" + "     |" + "     |" + "-----|");
    }
}