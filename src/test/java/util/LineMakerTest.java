package util;

import static org.assertj.core.api.Assertions.assertThat;

import domain.LineStatus;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineMakerTest {

    @Test
    @DisplayName("라인이 겹치는 경우가 있는지 확인")
    void makeRandomLine() {
        int numberOfLine = 1000;
        List<LineStatus> line = LineMaker.makeLine(new RandomLineGenerator(), numberOfLine);
        for (int i = 0; i < numberOfLine - 1; i++) {
            int rightLine = i+1;
            if (line.get(i) == LineStatus.EXIST) {
                assertThat(line.get(rightLine).getStatus()).isFalse();
            }
        }
    }
}
