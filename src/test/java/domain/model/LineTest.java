package domain.model;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class LineTest {

    @Test
    @DisplayName("우측으로 가로 라인이 있는 위치들을 반환한다")
    void findHorizontalTest() {
        //given
        Line line = new Line(() -> true, 4);
        //when
        List<Integer> expect = List.of(0, 2);
        List<Integer> actual = line.findRightConnectedPositions();
        //then
        Assertions.assertThat(expect).isEqualTo(actual);
    }

    @Test
    @DisplayName("특정 위치를 지정하면 이동할 방향을 정해준다.")
    void showDirectionTest() {
        //given
        Line line = new Line(() -> true, 4);
        //when
        Direction leftDirection = line.showDirection(1);
        Direction rightDirection = line.showDirection(2);
        //then
        Assertions.assertThat(leftDirection).isEqualTo(Direction.LEFT);
        Assertions.assertThat(rightDirection).isEqualTo(Direction.RIGHT);
    }

}
