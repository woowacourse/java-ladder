package laddergame.domain;

import laddergame.util.RandomRungGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineBuilderTest {
    @Test
    @DisplayName("주어진 횟수만큼 다리가 생성되는지 확인한다.")
    public void testRandomBuildStrategy() {
        //given
        final int count = 4;
        // when
        LineBuilder lineBuilder = new LineBuilder(new RandomRungGenerator(), count);

        //then
        assertEquals(lineBuilder.build().getLine().size(), count);
    }

    @Test
    @DisplayName("다리가 연속적으로 생성되지 않는지 검증한다.")
    public void testSequenceBridges() {
        //given
        final int count = 4;

        // when
        LineBuilder lineBuilder = new LineBuilder(new RandomRungGenerator(), count);
        Line line = lineBuilder.build();

        //then
        IntStream.range(0, line.getLine().size() - 1)
                .filter(i -> line.getLine().get(i).equals(Rung.BRIDGE))
                .forEach(i -> assertEquals(line.getLine().get(i + 1), Rung.EMPTY));
    }
}
