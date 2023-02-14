package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private int personCount = 5;
    private Line line;

    @BeforeEach
    void setup() {
        line = new Line(personCount);
    }

    @DisplayName("Line 생성 시, Line의 Bar개수가 사람 수보다 1 작은지 확인한다.")
    @Test
    void lineInitiatorTest() {
        //int 사람 수 넣으면, 리스트의 크기가 사람수-1인지
        assertThat(line.getLine().size())
                .isEqualTo(personCount - 1);
    }


    @DisplayName("Line의 가로 라인이 겹치지 않는지 확인한다.")
    @Test
    void getLineTest() {
        // 리스트가 연속된 true값을 갖지 않은지.
        boolean check = false;
        List<Boolean> bars = line.getLine();
        for (int idx = 0; idx < bars.size() - 1; idx++) {
            assertThat(!bars.get(idx) || !bars.get(idx + 1)).isTrue();
        }
    }
}
