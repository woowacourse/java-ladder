package laddergame.domain.strategy;

import laddergame.domain.Zone;
import laddergame.util.RandomZoneGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("랜덤전략")
public class ZonesBuilderTest {
    @Test
    @DisplayName("주어진 횟수만큼 다리가 생성되는지 확인한다.")
    public void testRandomBuildStrategy() {
        //given
        ZonesBuilder zonesBuilder =
                new ZonesBuilder(new RandomZoneGenerator());
        final int count = 4;

        //when
        List<Zone> canBuildBridges = zonesBuilder.build(count);

        //then
        assertEquals(canBuildBridges.size(), count);
    }

    @Test
    @DisplayName("다리가 연속적으로 생성되지 않는지 검증한다.")
    public void testSequenceBridges() {
        //given
        ZonesBuilder zonesBuilder =
                new ZonesBuilder(new RandomZoneGenerator());
        final int count = 5;

        //when
        List<Zone> canBuildBridges = zonesBuilder.build(count);

        //then
        IntStream.range(0, canBuildBridges.size() - 1)
                .filter(i -> canBuildBridges.get(i).equals(Zone.BRIDGE))
                .forEach(i -> assertEquals(canBuildBridges.get(i + 1), Zone.EMPTY));
    }
}
