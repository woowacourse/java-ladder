package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {

    @DisplayName("해당 위치는 첫번째 위치이다.")
    @Test
    void isFirstPositionTest() {
        //given
        Position position = new Position(0);

        //when
        boolean result = position.isFirst();

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("해당 위치는 마지막 위치이다.")
    @Test
    void isLastPositionTest() {
        //given
        Position position = new Position(4);
        int lineSize = 4;

        //when
        boolean result = position.isLast(lineSize);

        //then
        assertThat(result).isTrue();
    }
}
