package domain.model;

import domain.wrapper.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {

    @Test
    @DisplayName("사다리는 input 높이의 층들을 갖는다")
    void ladder() {
        Ladder ladder = new Ladder(5, 4);
        assertThat(ladder.getHeight()).isEqualTo(5);
    }

    @Test
    @DisplayName("사다리에 층을 추가하는 테스트")
    void addLayer() {
        Layer layer = new Layer();
        layer.makeLine(true);

        Ladder ladder = new Ladder(5, 5);

        ladder.addLayer(layer);

        assertThat(matchLayers(ladder, layer)).isEqualTo(true);
    }

    private boolean matchLayers(Ladder ladder, Layer layer) {
        if (ladder.getLayers().isEmpty()) {
            return false;
        }

        return ladder.getLayers()
                .stream()
                .allMatch(it -> it.equals(layer));
    }

    @DisplayName("현재 위치에서 양쪽에 다리가 있는지 확인")
    @Nested
    class HasLeftAndRight {
        Ladder ladder;

        @BeforeEach
        void setUp() {
            Layer layer = new Layer();
            layer.makeLine(true);
            layer.makeLine(false);
            layer.makeLine(true);
            ladder = new Ladder(2, 3);
            ladder.addLayer(layer);
            Layer layer2 = new Layer();
            layer2.makeLine(false);
            layer2.makeLine(true);
            layer2.makeLine(false);
            ladder.addLayer(layer2);
        }

        @ParameterizedTest(name = "({0}, {1}) 위치에서 왼쪽에 다리가 연결되어 있다")
        @CsvSource(value = {"1:0", "3:0", "2:1"}, delimiter = ':')
        void hasLeftAtTrue(int x, int y) {
            assertThat(ladder.hasLeftAt(Position.of(x, y))).isTrue();
        }

        @ParameterizedTest(name = "({0}, {1}) 위치에서 왼쪽에 다리가 연결되어있지 않다")
        @CsvSource(value = {"0:0", "2:0", "0:1", "1:1", "3:1"}, delimiter = ':')
        void hasLeftAtFalse(int x, int y) {
            assertThat(ladder.hasLeftAt(Position.of(x, y))).isFalse();
        }

        @ParameterizedTest(name = "({0}, {1}) 위치에서 오른쪽에 다리가 연결되어 있다")
        @CsvSource(value = {"0:0", "2:0"}, delimiter = ':')
        void hasRightAtTrue(int x, int y) {
            assertThat(ladder.hasRightAt(Position.of(x, y))).isTrue();
        }

        @ParameterizedTest(name = "({0}, {1}) 위치에서 오른쪽에 다리가 연결되어있지 않다")
        @CsvSource(value = {"1:0", "3:0"}, delimiter = ':')
        void hasRightAtFalse(int x, int y) {
            assertThat(ladder.hasRightAt(Position.of(x, y))).isFalse();
        }
    }
}
