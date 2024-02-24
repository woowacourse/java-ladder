package ladder.model;

import ladder.constant.LadderPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.constant.LadderPath.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @Test
    @DisplayName("연속된 경로가 있다면 가로줄 생성에서 예외가 발생한다.")
    void throwsExceptionWhenContinuousPathExistTest() {
        List<LadderPath> row = List.of(RIGHT, LEFT, RIGHT, RIGHT, STAY);

        assertThatThrownBy(() -> new Line(row))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("왼쪽 경로 왼쪽에 오른쪽 경로가 없다면 예외가 발생한다.")
    void throwsExceptionWhenNotExistRightBeforeLeft() {
        List<LadderPath> row = List.of(STAY, STAY, LEFT, STAY, STAY);

        assertThatThrownBy(() -> new Line(row))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("왼쪽 경로 왼쪽에 오른쪽 경로가 없습니다.");
    }

    @Test
    @DisplayName("왼쪽 경로 왼쪽이 없다면 예외가 발생한다.")
    void throwsExceptionWhenLeftOnFirst() {
        List<LadderPath> row = List.of(LEFT, STAY, STAY, STAY, STAY);

        assertThatThrownBy(() -> new Line(row))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("왼쪽 경로 왼쪽에 오른쪽 경로가 없습니다.");
    }

    @Test
    @DisplayName("오른쪽 경로 오른쪽에 왼쪽 경로가 없다면 예외가 발생한다.")
    void throwsExceptionWhenNotExistLeftAfterRight() {
        List<LadderPath> row = List.of(STAY, STAY, RIGHT, STAY, STAY);

        assertThatThrownBy(() -> new Line(row))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("오른쪽 경로 오른쪽에 왼쪽 경로가 없습니다.");
    }

    @Test
    @DisplayName("오른쪽 경로 오른쪽이 없다면 예외가 발생한다.")
    void throwsExceptionWhenRightOnEnd() {
        List<LadderPath> row = List.of(STAY, STAY, STAY, STAY, RIGHT);

        assertThatThrownBy(() -> new Line(row))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("오른쪽 경로 오른쪽에 왼쪽 경로가 없습니다.");
    }

    @Test
    @DisplayName("라인의 경로를 분석해서 사다리 막대 좌표를 추출해낼 수 있다.")
    void findBarsTest() {
        Line line = new Line(List.of(RIGHT, LEFT, STAY, RIGHT, LEFT));

        List<Integer> actual = line.findBars();
        List<Integer> expected = List.of(0, 3);

        assertThat(actual).isEqualTo(expected);
    }
}
