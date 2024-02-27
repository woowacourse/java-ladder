package domain.ladder;

import domain.Players;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("전략을 정해서 사다리를 만든다.")
    @Test
    void createLadder() {
        //given
        final Height height = new Height(5);
        final Players players = new Players(List.of("a", "b", "c", "d"));
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(List.of(false, true, false));

        //when
        final Ladder ladder = Ladder.createByStrategy(bridgeGenerator, height, Width.from(players));

        //then
        Assertions.assertThat(ladder.getLadder()).hasSize(height.getValue());
    }
}
