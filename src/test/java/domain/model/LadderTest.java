package domain.model;

import domain.vo.Height;
import domain.vo.Width;
import org.junit.jupiter.api.DisplayName;
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

    private boolean matchLayers(Ladder ladder, Layer layer) {
        if (ladder.getLayers().isEmpty()) {
            return false;
        }

        return ladder.getLayers()
                .stream()
                .allMatch(it -> it.equals(layer));
    }
}
