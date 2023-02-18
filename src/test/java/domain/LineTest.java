package domain;

import domain.util.Point;
import domain.util.PointGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LineTest {

    @Test
    @DisplayName("연속하지 않도록 교차하는 포인트들의 리스트를 반환해야한다.")
    void lineAlternativePointsGeneratingSuccessTest() {
        LadderWidth ladderWidth = new LadderWidth(5);

        List<Point> linePoints = Line.create(ladderWidth, PointGenerator.getInstance(false)).getPoints();
        Assertions.assertThat(linePoints).containsExactly(Point.PRESENCE, Point.ABSENCE, Point.PRESENCE, Point.ABSENCE, Point.PRESENCE);
    }

}