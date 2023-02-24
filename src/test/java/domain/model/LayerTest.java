package domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import domain.type.Line;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LayerTest {

    @Test
    @DisplayName("언제나 PassGenerator가 true를 반환할 때 Line 생성을 테스트한다.")
    public void makeLineWithAlwaysTrue() {
        //given
        Layer layer = new Layer(new ArrayList<>(), () -> true);

        //when
        IntStream.range(0, 10).forEach(i -> layer.makeLine());

        //then
        List<Line> lines = layer.getLines();
        IntStream.range(0, lines.size()).filter(i -> i % 2 == 0)
            .forEach(i -> assertThat(lines.get(i)).isEqualTo(Line.CONNECTED));
    }

    @Test
    @DisplayName("언제나 PassGenerator가 false를 반환할 때 Line 생성을 테스트한다.")
    public void makeLineWithAlwaysFalse() {
        //given
        Layer layer = new Layer(new ArrayList<>(), () -> false);

        //when
        IntStream.range(0, 10).forEach(i -> layer.makeLine());

        //then
        List<Line> lines = layer.getLines();
        lines.forEach(line -> assertThat(line).isEqualTo(Line.UNCONNECTED));
    }

    @Test
    @DisplayName("Layer가 Line을 생성한다.")
    public void makeLineSuccessTest() {
        //given
        Layer layer = new Layer(new ArrayList<>(), new RandomBooleanGenerator());

        //when
        int size = 10;
        IntStream.range(0, size).forEach(i -> layer.makeLine());

        //then
        assertThat(layer.getLines().size()).isEqualTo(size);
    }

    @ParameterizedTest(name = "{0} 사다리에서 현위치가 들어왔을 때 위치를 움직이는 경우")
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2"}, delimiter = ':')
    public void moveSuccessCase(int horizon, int result) {
        //given
        Layer layer = new Layer(new ArrayList<>(), () -> true);
        IntStream.range(0, 10).forEach(i -> layer.makeLine());
        Location location = new Location(horizon);

        //when
        layer.move(location);

        //then
        assertThat(location.getHorizon()).isEqualTo(result);
    }
}
