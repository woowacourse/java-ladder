package domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    @DisplayName("사다리 높이가 1~10 사이면 정상적으로 수행된다.")
    void LadderHeightSuccessTest(int height) {
        final Line line = new Line(List.of(Bridge.EXIST, Bridge.NON_EXIST, Bridge.EXIST));
        List<Line> lines = new ArrayList<>();
        for (int floor = 0; floor < height; floor++) {
            lines.add(line);
        }
        final Ladder ladder = new Ladder(lines);
        assertThat(ladder.getLadder().size()).isEqualTo(height);
    }
}
