package laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("라인")
public class LineTest {
    @Test
    @DisplayName("라인을 생성하는지 테스트한다.")
    public void createLineTest() {
        //given
        final int personCount = 4;

        //when
        Line line = new Line(personCount);

        //then
        assertEquals(line.getPoints().size(), personCount);
    }
}
