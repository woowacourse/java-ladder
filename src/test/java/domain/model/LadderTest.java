package domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @DisplayName("사다리 안의 각 층에서 라인을 생성함을 테스트")
    public void testMakeLineInLayers() {
        //given
        Height height = new Height(10);
        Width width = new Width(5);
        Ladder ladder = new Ladder(height, width,
            makeEmptyLayers(height, new RandomBooleanGenerator()));

        //when
        ladder.makeLineInLayers();

        //then
        IntStream.range(0, height.getValue())
            .forEach(index -> assertThat(ladder.getLayers().get(index).getLines()).isNotEmpty());
    }

    @Test
    @DisplayName("사다리의 각 층에서 짝수번째에만 라인이 있을 때 사다리 타기를 테스트")
    public void testRideLadderWhenOnlyHasLineAtEvenNumber() {
        //given
        Height height = new Height(5);
        Width width = new Width(2);
        List<Layer> layers = makeEmptyLayers(height, () -> true);
        Ladder ladder = new Ladder(height, width, layers);
        ladder.makeLineInLayers();
        Location location = new Location(0);

        //when
        int result = ladder.ride(location);

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리의 모든 층에 라인이 없을 때 사다리 타기를 테스트")
    public void testRideLadderWhenAllLayerHasNotLine() {
        //given
        Height height = new Height(5);
        Width width = new Width(2);
        List<Layer> layers = makeEmptyLayers(height, () -> false);
        Ladder ladder = new Ladder(height, width, layers);
        ladder.makeLineInLayers();
        Location location = new Location(1);

        //when
        int result = ladder.ride(location);

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리를 탈 수 없는 시작 시점이 들어왔을 경우")
    public void testRideLadderWhenStartLocationOutOfBound() {
        //given
        Height height = new Height(5);
        Width width = new Width(2);
        List<Layer> layers = makeEmptyLayers(height, () -> true);
        Ladder ladder = new Ladder(height, width, layers);
        ladder.makeLineInLayers();
        Location location = new Location(3);

        //when
        //then
        assertThatThrownBy(() -> ladder.ride(location))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Ladder 생성 시 높이와 List의 크기가 다를 시 예외")
    public void testCreateLadderWhenHeightAndListSizeNotMatch() {
        //given
        Height height = new Height(5);
        Width width = new Width(2);
        List<Layer> layers = makeEmptyLayers(new Height(6), () -> true);

        //when
        //then
        assertThatThrownBy(() -> new Ladder(height, width, layers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private List<Layer> makeEmptyLayers(final Height height, final BooleanGenerator booleanGenerator) {
        return IntStream.range(0, height.getValue())
            .mapToObj(index -> new Layer(new ArrayList<>(), booleanGenerator))
            .collect(Collectors.toList());
    }
}
