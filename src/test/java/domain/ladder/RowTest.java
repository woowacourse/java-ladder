package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {

    @Test
    @DisplayName("가로줄이 겹치지 않는 라인이 만들어지는가")
    void non_adjacent_line_created() {
        int width = 5;

        Row row = new Row(width, () -> Bridge.EXIST);
        List<Bridge> bridges = row.getBridges();

        for (int current = 1; current < bridges.size(); current++) {
            Bridge beforeBridge = bridges.get(current - 1);
            Bridge currentBridge = bridges.get(current);
            assertThat(beforeBridge.isExist() && currentBridge.isExist()).isFalse();
        }
    }
}
