package domain.ladder;

import domain.TestBridgeMakingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static domain.ladder.Bridge.EMPTY;
import static domain.ladder.Bridge.EXIST;
import static org.assertj.core.api.Assertions.assertThat;


class LadderTest {

    @Test
    @DisplayName("한 줄 사다리가 정상적인 크기로 생성되는가")
    void ladder_created_in_correct_size() {
        List<Bridge> bridges = List.of(EXIST, EMPTY, EXIST);
        TestBridgeMakingStrategy strategy = new TestBridgeMakingStrategy(bridges);
        int width = 3, height = 1;

        Ladder ladder = new Ladder(width, height, strategy);
        assertThat(ladder.getWidth()).isEqualTo(width);

        List<Row> rows = ladder.getRows();
        assertThat(rows.size()).isEqualTo(height);
    }

    @Test
    @DisplayName("여러 줄 사다리가 정상적인 크기로 생성되는가")
    void multiple_ladder_created_in_correct_size() {
        List<Bridge> bridges = List.of(EXIST, EMPTY, EXIST, EXIST, EMPTY, EXIST, EXIST, EMPTY, EXIST);
        TestBridgeMakingStrategy strategy = new TestBridgeMakingStrategy(bridges);
        int width = 3, height = 3;

        Ladder ladder = new Ladder(width, height, strategy);
        assertThat(ladder.getWidth()).isEqualTo(width);

        List<Row> rows = ladder.getRows();
        assertThat(rows.size()).isEqualTo(height);
    }

    @Test
    @DisplayName("사다리의 다리가 정상적으로 생성되는가")
    void is_ladder_bridge_creating_correctly() {
        List<Bridge> bridges = List.of(EXIST, EMPTY, EXIST, EXIST, EMPTY, EXIST, EXIST, EMPTY, EXIST);
        TestBridgeMakingStrategy strategy = new TestBridgeMakingStrategy(bridges);
        int width = 3, height = 3;

        Ladder ladder = new Ladder(width, height, strategy);

        for (Row row : ladder.getRows()) {
            List<Bridge> actual = List.of(EXIST, EMPTY, EXIST);
            assertThat(row.getBridges()).isEqualTo(actual);
        }
    }
}
