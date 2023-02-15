package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.NumberMaker;

@DisplayName("가로 라인은 ")
class LineTest {

    @DisplayName("연속된 선을 가질 수 없다.")
    @Test
    void addPointTest_continuous() {
        Line line = new Line(new FixedNumberMaker(), new ArrayList<>(List.of(true)));
        line.addPoint(1);
        assertThat(line.getPoints()).isEqualTo(List.of(true, false));
    }

    @DisplayName("앞에 선이 존재하지 않는다면 선을 생성할 수 있다.")
    @Test
    void addPointTest_1() {
        Line line = new Line(new FixedNumberMaker(), new ArrayList<>(List.of(false)));
        line.addPoint(1);
        assertThat(line.getPoints()).isEqualTo(List.of(false, true));
    }

    @DisplayName("앞에 선이 존재하지 않는다면 선을 생성하지 않을 수도 있다.")
    @Test
    void addPointTest_0() {
        Line line = new Line(new FixedNumberMaker(), new ArrayList<>(List.of(false)));
        line.addPoint(0);
        assertThat(line.getPoints()).isEqualTo(List.of(false, false));
    }

    private class FixedNumberMaker implements NumberMaker {
        @Override
        public boolean generateNumber(int bound) {
            return bound == 1;
        }
    }

}