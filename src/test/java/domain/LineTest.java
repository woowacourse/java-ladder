package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("false로 초기화된 라인을 생성한다.")
    @Test
    void createLine() {
        // given
        int personCount = 4;
        // when
        final Line line = new Line(personCount);
        // then
        Assertions.assertThat(line.getPoints()).containsAll(List.of(false, false, false, false));
    }

    @DisplayName("point는 연속될 수 없다.")
    @Test
    void notConsecutivePoints() {
        // given
        int personCount = 4;
        final Line line = new Line(personCount);
        // when & then
        Assertions.assertThat(line.getPoints()).containsAll(List.of(false, false, false, false));
    }

    @DisplayName("주어진 위치에 point가 없다.")
    @Test
    void hasPoint(){
        //given
        int personCount = 4;
        int position = 0;
        final Line line = new Line(personCount);
        //when & then
        Assertions.assertThat(line.hasPoint(position)).isFalse();
    }

    @DisplayName("주어진 위치에 point를 놓는다.")
    @Test
    void putPoint(){
        //given
        int personCount = 4;
        int position = 0;
        final Line line = new Line(personCount);
        //when
        line.putPoint(position);
        //then
        Assertions.assertThat(line.hasPoint(position)).isTrue();
    }
}