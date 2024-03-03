package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class LadderTest {

    @DisplayName("전략을 정해서 사다리를 만든다.")
    @Test
    void createLadder() {
        //given
        final int height = 3;
        final int personCount = 4;
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(
                List.of(false, true, false),
                List.of(true, false, false),
                List.of(true, false, true));

        //when
        final Ladder ladder = Ladder.createByStrategy(bridgeGenerator, height, personCount);

        //then
        assertThat(ladder.getLines()).hasSize(height);
    }

    @DisplayName("다리가 있으면 이동한다.")
    @Test
    void climbLadder() {
        //given
        final int height = 3;
        final int personCount = 4;
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(
                List.of(false, true, false),
                List.of(true, false, false),
                List.of(true, false, true));
        List<Integer> expectedDestinations = List.of(0, 3, 1, 2);
        final Ladder ladder = Ladder.createByStrategy(bridgeGenerator, height, personCount);

        //when & then
        assertAll(
                () -> assertThat(ladder.climb(new Position(0)).getValue()).isEqualTo(expectedDestinations.get(0)),
                () -> assertThat(ladder.climb(new Position(1)).getValue()).isEqualTo(expectedDestinations.get(1)),
                () -> assertThat(ladder.climb(new Position(2)).getValue()).isEqualTo(expectedDestinations.get(2)),
                () -> assertThat(ladder.climb(new Position(3)).getValue()).isEqualTo(expectedDestinations.get(3))
        );

    }
}
