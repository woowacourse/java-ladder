package laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import laddergame.util.BooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("라인")
public class LineTest {
    @Test
    @DisplayName("라인을 생성하는지 테스트한다.")
    public void createLineTest() {
        //given
        final int personCount = 4;
        final int expectedSize = personCount - 1;

        //when
        Line line = new Line(personCount);

        //then
        assertEquals(line.getPoints().size(), expectedSize);
    }

    @Test
    @DisplayName("랜덤값이 true일 경우 특정 위치에서 다리를 건설한다.")
    public void buildBridgeTest() {
        //given
        final int personCount = 4;
        final int position = 1;
        Line line = new Line(personCount);

        BooleanGenerator alwaysTrueGenerator = () -> true;

        //when
        line.buildBridge(position, alwaysTrueGenerator);

        //then
        assertTrue(line.isBuilt(position));
    }

}
