import domain.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    @DisplayName("라인을 생성한다.")
    void createLine() {
        assertThatCode(() -> new Line()).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("가로 길이는 사용자 수 -1 이다.")
    void createLineWithPersonCount() {
        //given
        int personCount = 4;
        //when
        //then
        assertThatCode(() -> new Line(personCount)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("무작위로 가로 라인을 생성한다.")
    void createRandomLine() {
        //given
        int personCount = 4;
        List<Boolean> expectedPoint = List.of(true, true, true);
        //when
        Line line = new Line(personCount);

        List<Boolean> line2 = line.generateRandomPoint();
        //then
        assertThat(line2).isEqualTo(expectedPoint);
    }


}
