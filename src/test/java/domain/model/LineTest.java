package domain.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static domain.model.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;


public class LineTest {
    @Test
    @DisplayName("사다리 생성 규칙에 맞게 사다리가 생성되는지 확인")
    void buildLineTest() {
        Line line = new Line(() -> true, 4);
        Line line2 = new Line(() -> false, 4);

        List<Direction> actual = new ArrayList<>();
        List<Direction> actual2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            actual.add(line.showDirection(i));
            actual2.add(line2.showDirection(i));
        }
        List<Direction> expected = List.of(RIGHT, LEFT, RIGHT, LEFT);
        List<Direction> expected2 = List.of(NONE, NONE, NONE, NONE);

        assertThat(actual).isEqualTo(expected);
        assertThat(actual2).isEqualTo(expected2);

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
        assertThat(leftDirection).isEqualTo(LEFT);
        assertThat(rightDirection).isEqualTo(RIGHT);
    }

}
