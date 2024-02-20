import domain.Line;
import domain.RandomGenerator;
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
        assertThatCode(() -> new Line(personCount, new RandomGenerator())).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("가로 라인은 겹치지 않는다.")
    void createRandomLine() {
        //given
        int personCount = 4;
        List<Boolean> expectedPoint = List.of(true, false, true);
        //when
        Line line = new Line(personCount, () -> true);

        //then
        assertThat(line.getPoints()).isEqualTo(expectedPoint);
    }
}
