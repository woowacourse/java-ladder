package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("이전 Point가 발판이 존재하면, 현재 Point에는 발판이 존재하지 않는다.")
    @Test
    void previousPointExistThenNotExist() {
        Point currentPoint = Point.choosePoint(Point.EXIST, new RandomPointGenerator());
        assertThat(currentPoint).isEqualTo(Point.NOT_EXIST);
    }

    @DisplayName("이전 Point가 발판이 존재하지 않으면, 현재 Point에는 발판이 존재하거나 존재하지 않는다.")
    @Test
    void previousPointNotExistThenExistOrNotExist() {
        Point currentPoint = Point.choosePoint(Point.NOT_EXIST, new ExistPointGenerator());
        assertThat(currentPoint).isEqualTo(Point.EXIST);

        currentPoint = Point.choosePoint(Point.EXIST, new NotExistPointGenerator());
        assertThat(currentPoint).isEqualTo(Point.NOT_EXIST);
    }
}
