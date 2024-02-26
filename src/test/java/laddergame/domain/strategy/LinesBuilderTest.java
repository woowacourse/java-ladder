package laddergame.domain.strategy;

import laddergame.domain.Line;
import laddergame.util.RandomLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("랜덤전략")
public class LinesBuilderTest {
    @Test
    @DisplayName("주어진 횟수만큼 다리가 생성되는지 확인한다.")
    public void testRandomBuildStrategy() {
        //given
        LinesBuilder linesBuilder =
                new LinesBuilder(new RandomLineGenerator());
        final int count = 4;

        //when
        List<Line> canBuildBridges = linesBuilder.build(count);

        //then
        assertEquals(canBuildBridges.size(), count);
    }

    @Test
    @DisplayName("다리가 연속적으로 생성되지 않는지 검증한다.")
    public void testSequenceBridges() {
        //given
        LinesBuilder linesBuilder =
                new LinesBuilder(new RandomLineGenerator());
        final int count = 5;

        //when
        List<Line> canBuildBridges = linesBuilder.build(count);

        //then
        IntStream.range(0, canBuildBridges.size() - 1)
                .filter(i -> canBuildBridges.get(i).equals(Line.BRIDGE))
                .forEach(i -> assertEquals(canBuildBridges.get(i + 1), Line.EMPTY));
    }
}
