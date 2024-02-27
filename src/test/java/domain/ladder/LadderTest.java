package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import domain.PickedBridgeGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("전략을 정해서 사다리를 만든다.")
    @Test
    void createLadder() {
        //given
        final Height height = new Height(5);
        final Width width = new Width(3);
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(List.of(
                false, true, false,
                false, true, false,
                false, true, false,
                false, true, false,
                false, true, false
        ));

        //when
        final Ladder ladder = Ladder.createByStrategy(bridgeGenerator, height, width);

        //then
        assertThat(ladder.getLadder()).hasSize(height.getValue());
    }

    @DisplayName("위치를 받으면 사다리를 따라 이동한 결과 위치를 반환한다.")
    @Test
    void climbLadder() {
        //given
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(List.of(
                true, false, true,
                false, true, false,
                true, false, false,
                false, true, false,
                true, false, true
        ));
        final Ladder ladder = Ladder.createByStrategy(bridgeGenerator, new Height(5), new Width(3));

        // when & then
        assertAll(
                () -> assertThat(ladder.calculateResultPosition(0)).isEqualTo(0),
                () -> assertThat(ladder.calculateResultPosition(1)).isEqualTo(3),
                () -> assertThat(ladder.calculateResultPosition(2)).isEqualTo(2),
                () -> assertThat(ladder.calculateResultPosition(3)).isEqualTo(1)
        );
    }
}
