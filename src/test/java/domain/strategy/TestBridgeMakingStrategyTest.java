package domain.strategy;

import domain.ladder.Bridge;
import domain.ladder.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static domain.ladder.Bridge.EXIST;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class TestBridgeMakingStrategyTest {

    @Test
    @DisplayName("연속한 다리가 입력되는 경우, 연속성을 없애는가")
    void deleteContinuousBridgesWhenContinuousBridgesCome() {
        List<Bridge> bridges = Collections.nCopies(5, EXIST);
        TestBridgeMakingStrategy strategy = new TestBridgeMakingStrategy(bridges);
        int width = 5;

        Row row = new Row(width, strategy);
        List<Bridge> actual = row.getBridges();

        assertSoftly(softly -> {
            for (int i = 1; i < actual.size(); i++) {
                Bridge previous = actual.get(i - 1), current = actual.get(i);
                softly.assertThat(previous.isExist() && current.isExist()).isFalse();
            }
        });
    }
}
