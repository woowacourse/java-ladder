package model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LayerTest {
    @Test
    void 디딤판이_존재하면_이동한다() {
        Layer layer = new Layer(List.of(Step.EXIST, Step.NONE));
        assertAll(
                () -> assertEquals(layer.move(0), 1),
                () -> assertEquals(layer.move(1), 0),
                () -> assertEquals(layer.move(2), 2)
        );
    }
}
