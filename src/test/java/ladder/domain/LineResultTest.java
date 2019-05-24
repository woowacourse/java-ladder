package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author heebg
 * @version 1.0 2019-05-24
 */
class LineResultTest {
    Line line;
    LineResult lineAnswerResult;
    LineResult lineResult;

    @BeforeEach
    void setUp() {
        List<Point> points = Arrays.asList(Point.RIGHT,Point.LEFT,Point.STRAIGHT,Point.RIGHT,Point.LEFT);
        line = Line.newInstance(points);
        lineAnswerResult = LineResult.newInstance(Arrays.asList(1, 0, 2, 4, 3));
        lineResult = LineResult.newInstance(line.size());
    }

    @Test
    void create_생성() {
        assertThat(lineResult).isEqualTo(LineResult.newInstance(Arrays.asList(0, 1, 2, 3, 4)));
    }

    @Test
    void move_확인() {
        System.out.println();
        for (Integer integer : lineAnswerResult) {
            System.out.print(integer);
        }
        assertThat(lineResult.move(line)).isEqualTo(lineAnswerResult);
    }
}