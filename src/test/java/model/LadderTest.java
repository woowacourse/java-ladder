package model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    void 사다리_게임_실행_결과를_올바르게_계산한다() {
        List<Layer> layers = new ArrayList<>();
        layers.add(new Layer(List.of(Step.EXIST, Step.NONE)));
        layers.add(new Layer(List.of(Step.NONE, Step.EXIST)));

        Ladder ladder = new Ladder(layers);
        assertAll(
                () -> assertEquals(ladder.move(0), 2),
                () -> assertEquals(ladder.move(1), 0),
                () -> assertEquals(ladder.move(2), 1)
        );
    }
}
