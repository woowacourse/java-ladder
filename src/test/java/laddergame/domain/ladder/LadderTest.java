package laddergame.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import laddergame.exception.LadderGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("사다리 상단 위치에 따라 사다리 하단 위치를 결정한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,1", "2,3", "3,2"})
    void goDown(int up, int down) {
        // given
        Position upPosition = new Position(up);

        Ladder ladder = new Ladder(List.of(new Line(List.of(Point.EXIST, Point.EMPTY, Point.EXIST)),
                new Line(List.of(Point.EXIST, Point.EMPTY, Point.EMPTY))));

        // when
        Position downPosition = ladder.goDown(upPosition);

        // then
        assertThat(downPosition).isEqualTo(new Position(down));
    }
}
