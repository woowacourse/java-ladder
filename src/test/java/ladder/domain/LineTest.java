package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("라인에는 사람의 수 - 1 만큼 좌표가 있다.")
    void createLine() {
        // given
        int personCount = 5;

        // when
        Line line = new Line(personCount, new RandomPointsGenerator(new Random()));
        int pointsSize = line.getPoints().size();

        // then
        assertThat(pointsSize).isEqualTo(personCount - 1);
    }

    @Test
    @DisplayName("랜덤으로 생성한 사다리 라인을 겹치지 않도록 수정한다.")
    void createNonOverlappingLine() {
        // given
        int personCount = 5;
        RandomPointsGenerator randomPointsGenerator = new RandomPointsGenerator(new Random() {
            @Override
            public boolean nextBoolean() {
                return true;
            }
        });

        // when
        Line line = new Line(personCount, randomPointsGenerator);

        // then
        assertThat(line.getPoints()).isEqualTo(List.of(Point.ON, Point.OFF, Point.ON, Point.OFF));
    }
}
