package domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import domain.type.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LayerTest {

    @Test
    @DisplayName("층이 랜덤으로 생성된다.")
    public void makeLayerByRandom() {
        //given
        int size = 5;

        //when
        Layer layer = Layer.makeLayerByRandom(size);

        //then
        assertThat(layer.getLines().size()).isEqualTo(size);
    }

    @Test
    @DisplayName("층이 랜덤으로 생성될 때 연속해서 연결 되지 않는다.")
    public void makeLayerByRandomNoContinuousConnected() {
        //given
        int size = 5;

        //when
        Layer layer = Layer.makeLayerByRandom(size);

        //then
        for (int i = 1; i < size; i++) {
            checkContinuousConnected(layer, i);
        }
    }

    private void checkContinuousConnected(Layer layer, int i) {
        if (layer.getLines().get(i - 1).equals(Line.CONNECTED) && layer.getLines().get(i)
            .equals(Line.CONNECTED)) {
            fail("연속해서 연결된 경우 실패");
        }
    }
}
