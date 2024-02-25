package laddergame.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import laddergame.domain.Zone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("랜덤전략")
public class RandomNoTrueSequenceBuildStrategyTest {
    @Test
    @DisplayName("주어진 횟수만큼 다리가 생성되는지 확인한다.")
    public void testRandomBuildStrategy() {
        //given
        RandomNoTrueSequenceBuildStrategy randomNoTrueSequenceBuildStrategy = new RandomNoTrueSequenceBuildStrategy();
        final int count = 4;

        //when
        List<Zone> canBuildBridges = randomNoTrueSequenceBuildStrategy.apply(count);

        //then
        assertEquals(canBuildBridges.size(), count);
    }

    @Test
    @DisplayName("다리가 연속적으로 생성되지 않는지 검증한다.")
    public void testSequenceBridges() {
        //given
        RandomNoTrueSequenceBuildStrategy randomNoTrueSequenceBuildStrategy = new RandomNoTrueSequenceBuildStrategy();
        final int count = 5;

        //when
        List<Zone> canBuildBridges = randomNoTrueSequenceBuildStrategy.apply(count);

        //then
        for (int i = 0; i < canBuildBridges.size() - 1; i++) {
            if (canBuildBridges.get(i).equals(Zone.BRIDGE)) {
                assertEquals(canBuildBridges.get(i + 1), Zone.EMPTY);
            }
        }
    }
}
