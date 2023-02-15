package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PointJudgeTest {

    List<Boolean> points;

    @Test
    @DisplayName("flag가 true이고 인덱스가 0이면 true가 반환된다")
    void getTrueIfFlagTrueIndexZero() {
        points = new ArrayList<>();
        boolean flag = true;
        int index = points.size();

        assertThat(PointJudge.canMake(points, flag, index)).isTrue();
    }

    @Test
    @DisplayName("flag가 true이고 이전 인덱스의 flag가 false이면 true가 반환된다.")
    void getTrueIfFlagTruePriorIndexFalse() {
        points = new ArrayList<>(List.of(true, false));
        boolean flag = true;
        int index = points.size();

        assertThat(PointJudge.canMake(points, flag, index)).isTrue();
    }

    @Test
    @DisplayName("flag가 false이면 반드시 false가 반환된다")
    void getFalseIfFlagFalse() {
        points = new ArrayList<>(List.of(true, false));
        boolean flag = false;
        int index = points.size();

        assertThat(PointJudge.canMake(points, flag, index)).isFalse();
    }

    @Test
    @DisplayName("flag가 true이고 이전 인덱스의 flag가 true이면 false가 반환된다.")
    void getFalseIfFlagTruePriorIndexTrue() {
        points = new ArrayList<>(List.of(false, true));
        boolean flag = true;
        int index = points.size();

        assertThat(PointJudge.canMake(points, flag, index)).isFalse();
    }
}
