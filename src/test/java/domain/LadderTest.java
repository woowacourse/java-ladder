package domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        Assertions.assertThat(ladder.getLines()).hasSize(height);
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
        org.junit.jupiter.api.Assertions.assertAll(
                () -> Assertions.assertThat(ladder.climb(0)).isEqualTo(expectedDestinations.get(0)),
                () -> Assertions.assertThat(ladder.climb(1)).isEqualTo(expectedDestinations.get(1)),
                () -> Assertions.assertThat(ladder.climb(2)).isEqualTo(expectedDestinations.get(2)),
                () -> Assertions.assertThat(ladder.climb(3)).isEqualTo(expectedDestinations.get(3))
        );

    }
}
