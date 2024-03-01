package domain.ladder;

import domain.strategy.TestBridgeMakingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static domain.ladder.Bridge.EMPTY;
import static domain.ladder.Bridge.EXIST;
import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {

    @Test
    @DisplayName("다리가 겹치지 않는 라인이 만들어지는가")
    void non_adjacent_line_created() {
        List<Bridge> bridges = List.of(EXIST, EMPTY, EXIST, EMPTY, EXIST);
        TestBridgeMakingStrategy strategy = new TestBridgeMakingStrategy(bridges);
        int width = 5;

        Row row = new Row(width, strategy);
        List<Bridge> actual = row.getBridges();

        for (int current = 1; current < actual.size(); current++) {
            Bridge previousBridge = actual.get(current - 1);
            Bridge currentBridge = actual.get(current);
            assertThat(previousBridge.isExist() && currentBridge.isExist()).isFalse();
        }
    }
}
