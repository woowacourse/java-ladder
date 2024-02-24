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
        final int height = 5;
        final int personCount = 4;
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(List.of(false, true, false));
        //when
        final Ladder ladder = Ladder.createByStrategy(bridgeGenerator, height, personCount);
        //then
        Assertions.assertThat(ladder.getLines()).hasSize(height);
    }
}
