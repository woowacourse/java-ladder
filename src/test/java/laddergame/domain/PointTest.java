package laddergame.domain;

import laddergame.domain.point.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {

    @DisplayName("boolean값으로 Point객체를 생성할 수 있다.")
    @Test
    void create() {
        // given&when
        Point point = Point.from(true);

        // then
        Assertions.assertThat(point.name()).isEqualTo(Point.EXIST.name());
    }

    @DisplayName("존재하면 true값을 반환한다.")
    @Test
    void isExist() {
        // given
        Point point = Point.EXIST;

        // when
        boolean result = point.isExist();

        // then
        Assertions.assertThat(result).isTrue();
    }

    @DisplayName("존재하지 않으면 false값을 반환한다.")
    @Test
    void notExist() {
        // given
        Point point = Point.EMPTY;

        // when
        boolean result = point.isExist();

        // then
        Assertions.assertThat(result).isFalse();
    }
}
