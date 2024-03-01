package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import domain.PickedBridgeGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FloorFactoryTest {

    @DisplayName("전략을 정해서 사다리 한 층을 만든다.")
    @Test
    void createLadder() {
        //given
        final Width width = new Width(3);
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(List.of(
                false, true, false
        ));

        //when
        final Floor floor = FloorFactory.createByStrategy(bridgeGenerator, width);

        //then
        assertThat(floor.getBridges()).
                containsExactlyElementsOf(List.of(Bridge.NOT_EXIST, Bridge.EXIST, Bridge.NOT_EXIST));
    }

    @DisplayName("사다리의 Bridge는 연속해서 존재하지 않도록 만들어진다.")
    @Test
    void createDistinctLadder() {
        //given
        final Width width = new Width(3);
        BridgeGenerator bridgeGenerator = new PickedBridgeGenerator(List.of(
                true, true, true
        ));

        //when
        final Floor floor = FloorFactory.createByStrategy(bridgeGenerator, width);

        //then
        assertThat(floor.getBridges()).
                containsExactlyElementsOf(List.of(Bridge.EXIST, Bridge.NOT_EXIST, Bridge.EXIST));
    }
}
