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
        line = Line.newBuilder().start(true).add(false).add(false).add(true).end();
        shape = TRUE_SHAPE + FALSE_SHAPE + FALSE_SHAPE + TRUE_SHAPE + FALSE_SHAPE;
        result = LineResult.newBuilder(Arrays.asList(1, 0, 2, 4, 3));
    }

    @Test
    void create_생성() {
        List<Position> line = new ArrayList<>();
        line.add(Position.add(false, true));
        assertThat(Line.newBuilder().start(true)).isEqualTo(Line.newBuilder(line));
    }

    @Test
    void create_리스트로_생성() {
        Line line = Line.newBuilder().start(true).add(false).add(true).end();
        for (Position position : line) {
            System.out.println(position.status());
        }
    }

    @Test
    void create_true_true_예외_start() {
        assertThrows(IllegalArgumentException.class, () -> {
            Line.newBuilder().start(true).add(true).add(false).end();
        });
    }

    @Test
    void create_newBuilder로_자동_생성() {
        Line line = Line.newBuilder(5);
        for (Position position : line) {
            System.out.println(position.status());
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
