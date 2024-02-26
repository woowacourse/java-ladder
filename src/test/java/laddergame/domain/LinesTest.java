package laddergame.domain;

import laddergame.domain.strategy.LinesBuilder;
import laddergame.util.LineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("라인")
public class LinesTest {
    private LinesBuilder linesBuilder;

    @Test
    @DisplayName("랜덤값이 Line.Empty이면 다리를 건설하지 않는다.")
    public void buildBridgeTest() {
        //given
        final int personCount = 4;
        final List<Line> expected = List.of(Line.EMPTY, Line.EMPTY, Line.EMPTY);

        LineGenerator lineGenerator = new LineGenerator() {
            @Override
            public Line generate() {
                return Line.EMPTY;
            }
        };

        LinesBuilder linesBuilder = new LinesBuilder(lineGenerator);

        //when
        Lines lines = new Lines(linesBuilder, personCount -1);

        //then
        assertEquals(lines.getLines(), expected);
    }
}

