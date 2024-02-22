package laddergame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import laddergame.domain.Line;
import laddergame.domain.LineSize;
import laddergame.domain.Names;
import laddergame.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {


    @DisplayName("중복되지 않은 라인을 생성한다.")
    @Test
    void create() {
        // given
        LineSize lineSize = new LineSize(new Names(List.of("pobi", "zeze", "crong", "jk")));

        // when
        Line line = Line.create(lineSize, () -> Point.EXIST);

        //then
        final List<Point> expectedLine = List.of(Point.EXIST, Point.EMPTY, Point.EXIST);

        assertThat(line).extracting("points")
                .isEqualTo(expectedLine);
    }
}
