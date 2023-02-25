package domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import domain.type.Line;
import domain.vo.Width;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LayerTest {

    @Test
    @DisplayName("짝수번째에만 라인을 생성함을 테스트")
    public void testOnlyMakeLineAtEvenNumber() {
        //given
        Layer layer = new Layer(new ArrayList<>(), () -> true);

        //when
        layer.makeLine(new Width(10));

        //then
        List<Line> lines = layer.getLines();
        IntStream.range(0, lines.size()).filter(i -> i % 2 == 0)
            .forEach(i -> assertThat(lines.get(i)).isEqualTo(Line.CONNECTED));
    }

    @Test
    @DisplayName("라인이 없는 다리를 생성함을 테스트")
    public void testMakeLineNotHasLine() {
        //given
        Layer layer = new Layer(new ArrayList<>(), () -> false);

        //when
        layer.makeLine(new Width(10));

        //then
        List<Line> lines = layer.getLines();
        lines.forEach(line -> assertThat(line).isEqualTo(Line.UNCONNECTED));
    }

    @Test
    @DisplayName("층이 라인을 생성하는 것을 테스트")
    public void testMakeLine() {
        //given
        Layer layer = new Layer(new ArrayList<>(), new RandomBooleanGenerator());

        //when
        int size = 10;
        layer.makeLine(new Width(size));

        //then
        assertThat(layer.getLines().size()).isEqualTo(size);
    }

    @ParameterizedTest(name = "사다리에서 현위치가 들어왔을 때 위치 움직임 테스트")
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2"}, delimiter = ':')
    public void testMoveInLayerGivenCurrentLocation(int horizon, int result) {
        //given
        Layer layer = new Layer(new ArrayList<>(), () -> true);
        layer.makeLine(new Width(10));
        Location location = new Location(horizon);

        //when
        layer.move(location);

        //then
        assertThat(location.getHorizon()).isEqualTo(result);
    }
}
