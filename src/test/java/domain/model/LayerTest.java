package domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import domain.type.Line;
import domain.vo.Location;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        Layer layer = new Layer(new ArrayList<>(), new RandomPassGenerator());

        //when
        int size = 10;
        IntStream.range(0, size).forEach(i -> layer.makeLine());

        //then
        assertThat(layer.getLines().size()).isEqualTo(size);
    }

    @Test
    @DisplayName("사다리에서 현위치가 들어왔을 때 위치를 움직이는 경우1")
    public void moveSuccessCase1() {
        //given
        Layer layer = new Layer(new ArrayList<>(), () -> true);
        int size = 10;
        IntStream.range(0, size).forEach(i -> layer.makeLine());
        int horizon = 0;
        int vertical = 0;
        Location location = new Location(horizon, vertical);

        //when
        layer.move(location);

        //then
        assertThat(location.getHorizon()).isEqualTo(++horizon);
        assertThat(location.getVertical()).isEqualTo(++vertical);
    }

    @Test
    @DisplayName("사다리에서 현위치가 들어왔을 때 위치를 움직이는 경우2")
    public void moveSuccessCase2() {
        //given
        Layer layer = new Layer(new ArrayList<>(), () -> false);
        int size = 10;
        IntStream.range(0, size).forEach(i -> layer.makeLine());
        int horizon = 0;
        int vertical = 0;
        Location location = new Location(horizon, vertical);

        //when
        layer.move(location);

        //then
        assertThat(location.getHorizon()).isEqualTo(horizon);
        assertThat(location.getVertical()).isEqualTo(++vertical);
    }
}
