package laddergame.domain.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import laddergame.domain.Points;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("랜덤전략")
public class PointBuildStrategyTest {
    @Test
    @DisplayName("주어진 횟수만큼 다리가 생성되는지 확인한다.")
    public void testRandomBuildStrategy() {
        //given
        PointBuildStrategy pointBuildStrategy = new PointBuildStrategy();
        final int count = 4;

        //when
        Points points = pointBuildStrategy.build(count);

        //then
        assertEquals(points.getPointSize(), count);
    }

    @Test
    @DisplayName("다리가 연속적으로 생성되지 않는지 검증한다.")
    public void testSequenceBridges() {
        //given
        PointBuildStrategy pointBuildStrategy = new PointBuildStrategy();
        final int count = 5;

        //when
        Points points = pointBuildStrategy.build(count);

        //then
        for (int i = 0; i < points.getPointSize() - 1; i++) {
            if (points.points().get(i).isBuilt()) {
                assertFalse(points.points().get(i + 1).isBuilt());
            }
        }
    }
}
