package ladder.model;

import ladder.constant.LadderPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.constant.LadderPath.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @Test
    @DisplayName("연속된 경로가 있다면 가로줄 생성에서 예외가 발생한다.")
    void throwsExceptionWhenContinuousPathExistTest() {
        List<LadderPath> continuousPath = List.of(RIGHT, LEFT, RIGHT, RIGHT, STAY);

        assertThatThrownBy(() -> new Line(continuousPath))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("오른쪽 경로 오른쪽에 왼쪽 경로가 없다면 예외가 발생한다.")
    void throwsExceptionWhenNotRL() {
        List<LadderPath> notRLPath = List.of(STAY, STAY, RIGHT, STAY, STAY);

        assertThatThrownBy(() -> new Line(notRLPath))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("왼쪽 경로 왼쪽에 오른쪽 경로가 없다면 예외가 발생한다.")
    void throwsExceptionWhenNotLR() {
        List<LadderPath> notLRPath = List.of(STAY, STAY, LEFT, STAY, STAY);

        assertThatThrownBy(() -> new Line(notLRPath))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("첫 번째 경로가 왼쪽이라면 예외가 발생한다.")
    void throwsExceptionWhenLeftFirst() {
        List<LadderPath> leftFirstPath = List.of(LEFT, STAY, STAY, STAY, STAY);

        assertThatThrownBy(() -> new Line(leftFirstPath))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("마지막 경로가 오른쪽이라면 예외가 발생한다.")
    void throwsExceptionWhenRightLast() {
        List<LadderPath> rightLastPath = List.of(STAY, STAY, STAY, STAY, RIGHT);

        assertThatThrownBy(() -> new Line(rightLastPath))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
