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

public class LineTest {


    @DisplayName("겹치는 포인트를 가지는 Line을 생성할 수 없다.")
    @Test
    void createByOverlapped() {
        // given
        final List<Point> points = List.of(Point.EXIST, Point.EXIST, Point.EMPTY);

        // when & then
        assertThatThrownBy(() -> new Line(points))
                .isInstanceOf(LadderGameException.class)
                .hasMessage("[ERROR] 포인트가 겹치는 라인을 생성할 수 없습니다.");
    }

    @DisplayName("겹치는 포인트가 없으면 Line을 생성할 수 있다.")
    @Test
    void create() {
        // given
        final List<Point> points = List.of(Point.EXIST, Point.EMPTY, Point.EXIST);

        // when & then
        assertThatCode(() -> new Line(points))
                .doesNotThrowAnyException();
    }

    @DisplayName("라인 범위 밖의 포지션은 이동 시 예외를 발생한다.")
    @Test
    void outOfRange() {
        // given
        Position position = new Position(4);
        Line line = new Line(List.of(Point.EXIST, Point.EMPTY, Point.EXIST));

        // when & then
        assertThatThrownBy(() -> line.goHorizontal(position))
                .isInstanceOf(LadderGameException.class)
                .hasMessage("[ERROR] Line 범위 밖의 포지션은 이동할 수 없습니다.");
    }

    @DisplayName("라인이 포지션으로 이동 후 다음 포지션을 결정한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,0", "2,3", "3,2"})
    void goHorizontal(int before, int after) {
        // given
        Position beforePosition = new Position(before);

        Line line = new Line(List.of(Point.EXIST, Point.EMPTY, Point.EXIST));

        // when
        Position afterPosition = line.goHorizontal(beforePosition);

        // then
        assertThat(afterPosition).isEqualTo(new Position(after));
    }
}
