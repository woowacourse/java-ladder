package domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import domain.vo.Height;
import domain.vo.Width;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("사다리 안의 각 층에 다리를 생성한다.")
    public void makeLineInLayersTest() {
        //given
        Height height = new Height(10);
        Width width = new Width(5);
        Ladder ladder = new Ladder(height, width, makeEmptyLayers(height));
        Ladder ladderDoNothing = new Ladder(height, width, makeEmptyLayers(height));

        //when
        ladder.makeLineInLayers();

        //then
        for (int i = 0; i < height.getValue(); i++) {
            assertThat(ladder.getLayers().get(i).getLines()).isNotEmpty();
            assertThat(ladderDoNothing.getLayers().get(i).getLines()).isEmpty();
        }
    }

    private List<Layer> makeEmptyLayers(Height height) {
        return IntStream.range(0, height.getValue())
            .mapToObj(index -> new Layer(new ArrayList<>(), new RandomPassGenerator()))
            .collect(Collectors.toList());
    }
}
