package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ExistBooleanGenerator;
import util.ConditionalBooleanGenerator;
import util.NonExistBooleanGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("참가자수-1만큼 status 생성")
    void makeLine() {
        int numberOfLineStatus = 3;
        Line line = new Line(numberOfLineStatus, new ConditionalBooleanGenerator());
        assertThat(line.getLine().size()).isEqualTo(numberOfLineStatus);
    }

    @Test
    @DisplayName("라인이 겹치는 경우가 존재하는지 확인")
    void makeRandomLines() {
        int numberOfLineStatus = 1000;
        Line line = new Line(numberOfLineStatus, new ConditionalBooleanGenerator());

        for (int i = 0; i < numberOfLineStatus - 1; i++) {
            int rightLineStatusIndex = i + 1;
            if (line.getLine().get(i) == LineStatus.EXIST) {
                Assertions.assertThat(line.getLine().get(rightLineStatusIndex)).isEqualTo(LineStatus.NON_EXIST);
            }
        }
    }

    @Test
    @DisplayName("다리가 존재하는 Line생성")
    void makeExistLine() {
        int numberOfLineStatus = 1;
        Line line = new Line(numberOfLineStatus, new ExistBooleanGenerator());

        assertThat(line.getLine().get(0)).isEqualTo(LineStatus.EXIST);
    }

    @Test
    @DisplayName("다리가 존재하지 않는 Line생성")
    void makeNonExistLine() {
        int numberOfLineStatus = 3;
        Line line = new Line(numberOfLineStatus, new NonExistBooleanGenerator());

        assertThat(line.getLine().get(0)).isEqualTo(LineStatus.NON_EXIST);
    }
}
