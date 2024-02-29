package laddergame.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PointTest {

    @DisplayName("True로 Point의 EXIST 상태를 생성한다.")
    @Test
    void fromTrue() {
        // given
        boolean input = true;

        // when
        final Point point = Point.from(input);

        // then
        assertThat(point).isEqualTo(Point.EXIST);
    }

    @DisplayName("True로 Point의 EXIST 상태를 생성한다.")
    @Test
    void fromFalse() {
        // given
        boolean input = false;

        // when
        final Point point = Point.from(input);

        // then
        assertThat(point).isEqualTo(Point.EMPTY);
    }

    @DisplayName("현재 포인트의 상태가 EXIST이면 다음 포인트는 무족건 EMPTY 이다.")
    @ParameterizedTest
    @ValueSource(strings = {"EXIST", "EMPTY"})
    void existNext(Point point) {
        // given
        Point nowPoint = Point.EXIST;

        // when
        final Point nextPoint = nowPoint.next(point);

        // then
        assertThat(nextPoint).isEqualTo(Point.EMPTY);
    }

    @DisplayName("현재 포인트의 상태가 EMPTY이면 다음 포인트는 무족건 입력 값이다.")
    @ParameterizedTest
    @ValueSource(strings = {"EXIST", "EMPTY"})
    void emptyNext(Point point) {
        // given
        Point nowPoint = Point.EMPTY;

        // when
        final Point nextPoint = nowPoint.next(point);

        // then
        assertThat(nextPoint).isEqualTo(point);
    }


}
