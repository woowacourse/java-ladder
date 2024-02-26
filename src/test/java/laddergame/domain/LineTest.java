package laddergame.domain;

import laddergame.domain.strategy.ZonesBuilder;
import laddergame.util.RandomZoneGenerator;
import laddergame.util.ZoneGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("라인")
public class LineTest {
    @Test
    @DisplayName("랜덤값이 Zone.Empty이면 다리를 건설하지 않는다.")
    public void buildBridgeTest() {
        //given
        final int personCount = 4;
        final List<Zone> expected = List.of(Zone.EMPTY, Zone.EMPTY, Zone.EMPTY);

        ZoneGenerator zoneGenerator = new ZoneGenerator() {
            @Override
            public Zone generate() {
                return Zone.EMPTY;
            }
        };

        ZonesBuilder zonesBuilder = new ZonesBuilder(zoneGenerator);

        //when
        Line line = new Line(zonesBuilder, personCount -1);

        //then
        assertEquals(line.getZones(), expected);
    }
}

