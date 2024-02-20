package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.TrueGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("한 층이 잘 생성된다.")
    void makeLineTest() {
        Line line = new Line(3, new TrueGenerator());

        assertThat(line.getPoints()).isEqualTo(List.of(true, false, true));
    }

    @Test
    @DisplayName("해당 위치에 가로 라인이 있는지 확인한다.")
    void isPointExistTest() {
        Line line = new Line(3, new TrueGenerator());

        assertThat(line.isExistPoint(1)).isFalse();
    }

}
