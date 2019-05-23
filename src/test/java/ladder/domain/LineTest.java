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
        List<Point> points = Arrays.asList(Point.TRUE,Point.FALSE,Point.FALSE,Point.TRUE,Point.FALSE);
        line = Line.newInstance(points);
        shape = TRUE_SHAPE + FALSE_SHAPE + FALSE_SHAPE + TRUE_SHAPE + FALSE_SHAPE;
        result = LineResult.newInstance(Arrays.asList(1, 0, 2, 4, 3));
    }

    @Test
    void create_생성() {
        List<Point> line = Arrays.asList(Point.TRUE);
        assertThat(Line.newInstance(line)).isEqualTo(Line.newInstance(Arrays.asList(Point.TRUE)));
    }

    @Test
    void create_리스트로_생성() {
        Line line = Line.newInstance().start().add().add().end();
        for (Point position : line) {
            System.out.println(position.status());
        }
        assertThat(line.size()).isEqualTo(4);
    }

    @Test
    void create_newBuilder로_자동_생성() {
        Line line = Line.newInstance(5);
        for (Point point : line) {
            System.out.println(point.status());
        }
    }

    @Test
    void draw_확인() {
        System.out.println(line.draw(TRUE_SHAPE, FALSE_SHAPE));
        assertThat(line.draw(TRUE_SHAPE, FALSE_SHAPE)).isEqualTo(shape);
    }

    @Test
    void move_확인() {
        for (Integer integer : line.move()) {
            System.out.print(integer);
        }
        System.out.println();
        for (Integer integer : result) {
            System.out.print(integer);
        }
        assertThat(line.move()).isEqualTo(result);
    }

}
