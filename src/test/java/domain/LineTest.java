package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.PresentStepGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {

    @Test
    @DisplayName("한 층이 잘 생성된다.")
    void makeLineTest() {
        Line line = new Line(3, new PresentStepGenerator());

        assertThat(line.getStepPoints()).isEqualTo(List.of(StepPoint.PRESENT, StepPoint.ABSENT, StepPoint.PRESENT));
    }

    @Test
    @DisplayName("해당 위치에 가로 라인이 있는지 확인한다.")
    void isStepExistAtTest() {
        Line line = new Line(3, new PresentStepGenerator());

        assertThat(line.isStepExistAt(1)).isFalse();
    }

    @Test
    @DisplayName("현재 위치를 이용해 이후 위치를 결정한다.")
    void findNextLocationTest() {
        Line line = new Line(3, new PresentStepGenerator());

        assertAll(() -> assertEquals(line.findNextLocation(0), 1),
                () -> assertEquals(line.findNextLocation(1), 0),
                () -> assertEquals(line.findNextLocation(2), 3),
                () -> assertEquals(line.findNextLocation(3), 2));
    }

}
