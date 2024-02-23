package laddergame.domain.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import laddergame.dto.LineBuildResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("랜덤전략")
public class RandomBuildStrategyTest {
    @Test
    @DisplayName("주어진 횟수만큼 다리가 생성되는지 확인한다.")
    public void testRandomBuildStrategy() {
        //given
        RandomBuildStrategy randomBuildStrategy = new RandomBuildStrategy();
        final int count = 4;

        //when
        LineBuildResult canBuildBridges = randomBuildStrategy.apply(count);

        //then
        assertEquals(canBuildBridges.buildResults().size(), count);
    }

    @Test
    @DisplayName("다리가 연속적으로 생성되지 않는지 검증한다.")
    public void testSequenceBridges() {
        //given
        RandomBuildStrategy randomBuildStrategy = new RandomBuildStrategy();
        final int count = 5;

        //when
        LineBuildResult canBuildBridges = randomBuildStrategy.apply(count);

        //then
        for (int i = 0; i < canBuildBridges.buildResults().size() - 1; i++) {
            if (canBuildBridges.buildResults().get(i)) {
                assertFalse(canBuildBridges.buildResults().get(i + 1));
            }
        }
    }
}
