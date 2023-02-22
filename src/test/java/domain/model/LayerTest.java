package domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LayerTest {

    @Test
    @DisplayName("다리는 연속해서 연결되지 않는다")
    void makeLineTest() {
        Layer layer = new Layer();
        layer.makeLine(true);
        layer.makeLine(true);
        assertThat(layer.getLines().get(1)).isFalse();
    }

    @Test
    @DisplayName("다리는 연결된다")
    void makeLineTest2() {
        Layer layer = new Layer();
        layer.makeLine(true);
        assertThat(layer.getLines().get(0)).isTrue();
    }

    @Test
    @DisplayName("포지션에 해당하는 다리가 있는지를")
    void test1() {
        Layer layer = new Layer();
        layer.makeLine(true);
        layer.makeLine(true);
        layer.makeLine(true);

        assertThat(layer.getLine(0)).isTrue();
        assertThat(layer.getLine(1)).isFalse();
        assertThat(layer.getLine(2)).isTrue();
    }
}
