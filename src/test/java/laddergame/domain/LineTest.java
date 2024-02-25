package laddergame.domain;

import laddergame.domain.strategy.LineBuildStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("라인")
public class LineTest {
    @Test
    @DisplayName("랜덤값이 true일 경우 특정 위치에서 다리를 건설한다.")
    public void buildBridgeTest() {
        //given
        final int personCount = 4;
        final List<Zone> expected = List.of(Zone.BRIDGE, Zone.EMPTY, Zone.BRIDGE);

        LineBuildStrategy lineBuildStrategy = new LineBuildStrategy() {
            @Override
            public List<Zone> apply(int count) {
                return expected;
            }
        };
        lineBuildStrategy.apply(personCount);

        //when
        Line line = Line.buildOf(lineBuildStrategy, personCount);

        //then
        assertEquals(line.getZones(), expected);
    }
}

