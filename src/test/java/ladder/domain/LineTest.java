package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0 2019-05-18
 */
public class LineTest {
    Line line;
    String FALSE_SHAPE = "|     ";
    String TRUE_SHAPE = "|-----";
    String shape;
    LineResult result;

    @BeforeEach
    void setUp() {
        List<Point> points = Arrays.asList(Point.RIGHT,Point.LEFT,Point.STRAIGHT,Point.RIGHT,Point.LEFT);
        line = Line.newInstance(points);
        shape = TRUE_SHAPE + FALSE_SHAPE + FALSE_SHAPE + TRUE_SHAPE + FALSE_SHAPE;
        result = LineResult.newInstance(Arrays.asList(1, 0, 2, 4, 3));
    }

    @Test
    void create_생성() {
        List<Point> line = Arrays.asList(Point.RIGHT);
        assertThat(Line.newInstance(line)).isEqualTo(Line.newInstance(Arrays.asList(Point.RIGHT)));
    }

    @Test
    void create_리스트로_생성() {
        Line line = Line.newInstance().start().add().add().end();
        for (Point point : line) {
            System.out.println(point);
        }
        assertThat(line.size()).isEqualTo(4);
    }

    @Test
    void create_newBuilder로_자동_생성() {
        Line line = Line.newInstance(5);
        for (Point point : line) {
            System.out.println(point);
        }
    }

    @Test
    void draw_확인() {
        System.out.println(line.draw(TRUE_SHAPE, FALSE_SHAPE));
        assertThat(line.draw(TRUE_SHAPE, FALSE_SHAPE)).isEqualTo(shape);
    }

}
