package domain.model;

import domain.vo.Height;
import domain.vo.Width;
import domain.wrapper.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    @Test
    @DisplayName("사다리는 input 높이의 층들을 갖는다")
    void ladder() {
        final Height height = new Height(5);
        final Width width = new Width(4);
        Ladder ladder = new Ladder(height, width);
        assertThat(ladder.getHeight().getValue()).isEqualTo(5);
    }

    @Test
    @DisplayName("사다리에 층을 추가하는 테스트")
    void addLayer() {
        Layer layer = new Layer();
        layer.makeLine(true);

        Ladder ladder = new Ladder(new Height(5), new Width(5));

        ladder.addLayer(layer);

        assertThat(matchLayers(ladder, layer)).isEqualTo(true);
    }

    @Nested
    class HasLeftAndRight {
        Ladder ladder;

        @BeforeEach
        void setUp() {
            Layer layer = new Layer();
            layer.makeLine(true);
            layer.makeLine(false);
            layer.makeLine(true);
            ladder = new Ladder(new Height(2), new Width(3));
            ladder.addLayer(layer);
            Layer layer2 = new Layer();
            layer2.makeLine(false);
            layer2.makeLine(true);
            layer2.makeLine(false);
            ladder.addLayer(layer2);
        }

        @Test
        void hasLeftAt() {
            assertThat(ladder.hasLeftAt(Position.of(0, 0))).isFalse();
            assertThat(ladder.hasLeftAt(Position.of(1, 0))).isTrue();
            assertThat(ladder.hasLeftAt(Position.of(2, 0))).isFalse();
            assertThat(ladder.hasLeftAt(Position.of(3, 0))).isTrue();

            assertThat(ladder.hasLeftAt(Position.of(0, 1))).isFalse();
            assertThat(ladder.hasLeftAt(Position.of(1, 1))).isFalse();
            assertThat(ladder.hasLeftAt(Position.of(2, 1))).isTrue();
            assertThat(ladder.hasLeftAt(Position.of(3, 1))).isFalse();
        }

        @Test
        void hasRightAt() {
            assertThat(ladder.hasRightAt(Position.of(0, 0))).isTrue();
            assertThat(ladder.hasRightAt(Position.of(1, 0))).isFalse();
            assertThat(ladder.hasRightAt(Position.of(2, 0))).isTrue();
            assertThat(ladder.hasRightAt(Position.of(3, 0))).isFalse();
        }
    }


    private boolean matchLayers(Ladder ladder, Layer layer) {
        if (ladder.getLayers().isEmpty()) {
            return false;
        }

        return ladder.getLayers()
                .stream()
                .allMatch(it -> it.equals(layer));
    }
}
