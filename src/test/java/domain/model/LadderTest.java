package domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import domain.vo.Height;
import domain.vo.Location;
import domain.vo.Width;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("사다리 안의 각 층에 다리를 생성한다.")
    public void makeLineInLayersTest() {
        //given
        Height height = new Height(10);
        Width width = new Width(5);
        Ladder ladder = new Ladder(height, width,
            makeEmptyLayers(height, new RandomPassGenerator()));

        //when
        //then
        IntStream.range(0, height.getValue())
            .forEach(index -> assertThat(ladder.getLayers().get(index).getLines()).isNotEmpty());
    }

    @Test
    @DisplayName("사다리 타기에 성공하는 경우1")
    public void rideSuccessTestCase1() {
        //given
        Height height = new Height(5);
        Width width = new Width(2);
        List<Layer> layers = makeEmptyLayers(height, () -> true);
        Ladder ladder = new Ladder(height, width, layers);
        Location location = new Location(0, 0);

        //when
        int result = ladder.ride(location);

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리 타기에 성공하는 경우2")
    public void rideSuccessTestCase2() {
        //given
        Height height = new Height(5);
        Width width = new Width(2);
        List<Layer> layers = makeEmptyLayers(height, () -> false);
        Ladder ladder = new Ladder(height, width, layers);
        Location location = new Location(1, 0);

        //when
        int result = ladder.ride(location);

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리를 탈 수 없는 시작 시점이 들어왔을 경우")
    public void rideStartIndexOutOfBoundFailure() {
        //given
        Height height = new Height(5);
        Width width = new Width(2);
        List<Layer> layers = makeEmptyLayers(height, () -> true);
        Ladder ladder = new Ladder(height, width, layers);
        Location location = new Location(3, 0);

        //when
        //then
        Assertions.assertThatThrownBy(() -> ladder.ride(location))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private List<Layer> makeEmptyLayers(final Height height, final PassGenerator passGenerator) {
        return IntStream.range(0, height.getValue())
            .mapToObj(index -> new Layer(new ArrayList<>(), passGenerator))
            .collect(Collectors.toList());
    }

}
