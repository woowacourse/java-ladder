package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import laddergame.exception.LadderGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("라인의 길이가 다른 사다리를 생성할 수 없다.")
    @Test
    void createDifferentSize() {
        // given
        final List<Line> lines = List.of(new Line(List.of(Point.EXIST, Point.EMPTY, Point.EXIST)),
                new Line(List.of(Point.EXIST, Point.EMPTY)));

        // when & then
        assertThatThrownBy(() -> new Ladder(lines))
                .isInstanceOf(LadderGameException.class)
                .hasMessage("[ERROR] 라인 길이가 다른 사다리를 생성할 수 없습니다.");
    }

    @DisplayName("라인의 길이가 같은 사다리를 생성한다.")
    @Test
    void createSameSize() {
        // given
        final List<Line> lines = List.of(new Line(List.of(Point.EXIST, Point.EMPTY, Point.EXIST)),
                new Line(List.of(Point.EXIST, Point.EMPTY, Point.EXIST)));

        // when & then
        assertThatCode(() -> new Ladder(lines))
                .doesNotThrowAnyException();
    }
}
