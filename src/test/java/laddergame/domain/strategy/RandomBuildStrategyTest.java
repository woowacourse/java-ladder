package laddergame.domain.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomBuildStrategyTest {
    @Test
    @DisplayName("주어진 횟수만큼 다리가 생성되는지 확인한다.")
    public void testRandomBuildStrategy() {
        //given
        RandomBuildStrategy randomBuildStrategy = new RandomBuildStrategy();
        final int count = 4;

        //when
        List<Boolean> canBuildBridges = randomBuildStrategy.canBuildBridges(count);

        //then
        assertEquals(canBuildBridges.size(), count);
    }
}
