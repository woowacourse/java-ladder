package model;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LayerTest {
    @Test
    void 각_사다리층의_디딤판을_생성할_수_있는_공간은_참여자_수에따라_결정된다() {
        int numberOfParticipants = 5;
        Assertions.assertEquals(4, new Layer(numberOfParticipants).getLayerSize());
    void 디딤판이_존재하면_이동한다() {
        Layer layer = new Layer(List.of(Step.EXIST, Step.NONE));
        assertAll(
                () -> assertEquals(layer.move(0), 1),
                () -> assertEquals(layer.move(1), 0),
                () -> assertEquals(layer.move(2), 2)
        );
    }
}
