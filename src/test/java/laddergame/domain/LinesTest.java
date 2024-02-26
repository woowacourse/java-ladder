package laddergame.domain;

import laddergame.util.LinesGenerator;
import laddergame.util.RandomLinesGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("라인")
public class LinesTest {
    @Test
    @DisplayName("랜덤값이 Line.Empty이면 다리를 건설하지 않는다.")
    public void buildBridgeTest() {
        //given
        final int personCount = 4;
        final List<Line> expected = List.of(Line.EMPTY, Line.EMPTY, Line.EMPTY);

        LinesGenerator expectedLinesGenerator = new LinesGenerator() {
            @Override
            public List<Line> generate(int width) {
                return expected;
            }
        };

        //when
        Lines lines = new Lines(expectedLinesGenerator, personCount -1);

        //then
        assertEquals(lines.getLines(), expected);
    }
}

