package laddergame.domain.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("랜덤전략")
public class RandomBuildStrategyTest {
    @Test
    @DisplayName("주어진 횟수만큼 다리가 생성되는지 확인한다.")
    public void testRandomBuildStrategy() {
        //given
        RandomBuildStrategy randomBuildStrategy = new RandomBuildStrategy();
        final int count = 4;

        //when
        List<Boolean> canBuildBridges = randomBuildStrategy.apply(count);

        //then
        assertEquals(canBuildBridges.size(), count);
    }

    @Test
    @DisplayName("다리가 연속적으로 생성되지 않는지 검증한다.")
    public void testSequenceBridges() {
        //given
        RandomBuildStrategy randomBuildStrategy = new RandomBuildStrategy();
        final int count = 5;

        //when
        List<Boolean> canBuildBridges = randomBuildStrategy.apply(count);

        //then
        for (int i = 0; i < canBuildBridges.size() - 1; i++) {
            if (canBuildBridges.get(i)) {
                assertFalse(canBuildBridges.get(i + 1));
            }
        }
    }
}
