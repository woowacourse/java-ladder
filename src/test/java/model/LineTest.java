package model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("라인 객체를 생성한다.")
    void createLine() {
        int personCount = 4;

        Assertions.assertThatCode(() -> new Line(personCount))
                .doesNotThrowAnyException();
    }


    @RepeatedTest(10)
    @DisplayName("동일한 true 값을 가지지 않는지 확인한다.")
    void overlapConnection() {
        //given
        Line line = new Line(4);
        List<Boolean> points = line.getPoints();

        //when
        boolean isOverlap = false;
        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i) && points.get(i + 1)) {
                isOverlap = true;
            }
        }

        //then
        Assertions.assertThat(isOverlap).isFalse();
    }
}
