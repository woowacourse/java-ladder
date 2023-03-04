package factory;

import domain.Line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineFactoryTest {

    @DisplayName("사다리 높이와 사람 수를 입력 받아 라인을 생성한다.")
    @Test
    void generateLine() {
        int maxPoint = 5;
        Line line = LineFactory.of(maxPoint);
        assertThat(line.getPoints().size())
                .isEqualTo(maxPoint);
    }

}
