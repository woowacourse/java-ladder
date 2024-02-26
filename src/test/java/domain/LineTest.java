package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.PresentStepGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("한 층이 잘 생성된다.")
    void makeLineTest() {
        Line line = new Line(3, new PresentStepGenerator());

        assertThat(line.getStepPoints()).isEqualTo(List.of(StepPoint.PRESENT, StepPoint.ABSENT, StepPoint.PRESENT));
    }

    @Test
    @DisplayName("해당 위치에 가로 라인이 있는지 확인한다.")
    void isPointExistAtTest() {
        Line line = new Line(3, new PresentStepGenerator());

        assertThat(line.isExistStep(1)).isFalse();
    }

    @Test
    @DisplayName("해당 위치에서 왼쪽으로 갈 수 있는지 확인한다.")
    void isExistLeftStepTest() {
        Line line = new Line(3, new PresentStepGenerator());

        assertThat(line.isExistLeftStepTest(1)).isTrue();
    }


}
