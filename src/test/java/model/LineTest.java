package model;

import java.util.List;
import model.strategy.RandomBuildStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("라인 객체를 생성한다.")
    void createLine() {
        int personCount = 4;

        Assertions.assertThatCode(() -> new Line(personCount, new RandomBuildStrategy()))
                .doesNotThrowAnyException();
    }


    @RepeatedTest(10)
    @DisplayName("연속한 두개의 LadderStatus가 true 값을 가지지 않는지 확인한다.")
    void overlapConnection() {
        //given
        Line line = new Line(4, new RandomBuildStrategy());
        List<LadderStatus> points = line.getPoints();

        //when
        boolean isOverlap = false;
        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i).isConnected() && points.get(i + 1).isConnected()) {
                isOverlap = true;
                break;
            }
        }

        //then
        Assertions.assertThat(isOverlap).isFalse();
    }

    @Test
    @DisplayName("LadderStatus가 flase인 라인을 생성한다.")
    void createNonStepLine() {
        //given
        Line line = new Line(4, new NothingBuildStrategy());

        //when
        List<LadderStatus> points = line.getPoints();

        //then
        Assertions.assertThat(points).containsOnly(LadderStatus.from(false));

    }
}
