package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderFactoryTest {

    @Test
    @DisplayName("주어진 가로 길이와 세로 길이의 랜덤 사다리를 생성한다.")
    void createRandomLadder() {
        Ladder ladder = LadderFactory.createRandomLadder(5, 10);

        assertAll(
                () -> assertThat(ladder.getHeight()).isEqualTo(5),
                () -> assertThat(ladder.getWidth()).isEqualTo(10)
        );
    }

    @Test
    @DisplayName("주어진 가로 길이와 세로 길이의 사다리를 생성한다.")
    void createManualLadder() {
        Line line = new Line(List.of(Bridge.NON_BRIDGE, Bridge.NON_BRIDGE, Bridge.NON_BRIDGE));
        List<Line> lines = List.of(line, line, line);
        Ladder ladder = LadderFactory.createLadder(lines);

        assertAll(
                () -> assertThat(ladder.getHeight()).isEqualTo(3),
                () -> assertThat(ladder.getWidth()).isEqualTo(3)
        );
    }
}
