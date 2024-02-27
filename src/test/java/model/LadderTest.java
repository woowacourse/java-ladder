package model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import model.dto.LayerSteps;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    void 디딤판이_존재하면_이동한다() {
        Ladder ladder = new Ladder(1, 2);
        LayerSteps layerSteps = new LayerSteps(List.of(Step.EXIST, Step.NONE));
        assertAll(
                () -> assertEquals(ladder.move(layerSteps.steps(), 0), 1),
                () -> assertEquals(ladder.move(layerSteps.steps(), 1), 0),
                () -> assertEquals(ladder.move(layerSteps.steps(), 2), 2)
        );
    }
}
