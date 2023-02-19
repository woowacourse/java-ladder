package generator;

import domain.BridgeStatus;
import domain.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static domain.BridgeStatus.EMPTY;
import static domain.BridgeStatus.EXIST;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGeneratorTest {

    @Test
    @DisplayName("절대 겹쳐지지 않는 브릿지가 만들어진다.")
    void test_createBridge_never_overlapped() {
        LineGenerator lineGenerator = new LineGenerator(() -> EXIST);
        Bridge bridge = lineGenerator.generate(7);

        List<BridgeStatus> bridgeStatuses = bridge.getBridges();

        assertThat(bridgeStatuses).containsExactly(EXIST, EMPTY, EXIST, EMPTY, EXIST, EMPTY);
    }

    @Test
    @DisplayName("[경계값 테스트] 절대 겹쳐지지 않는 브릿지가 만들어진다.")
    void test_createBridge_never_overlapped_boundary() {
        LineGenerator lineGenerator = new LineGenerator(() -> EXIST);
        Bridge bridge = lineGenerator.generate(2);

        List<BridgeStatus> bridgeStatuses = bridge.getBridges();

        assertThat(bridgeStatuses).containsExactly(EXIST);
    }

    @Test
    @DisplayName("[실제 예시 테스트] 절대 겹쳐지지 않는 브릿지가 만들어진다.")
    void test_createBridge_never_overlapped_sample() {
        List<BridgeStatus> bridgeStatuses = List.of(EMPTY, EMPTY, EXIST, EXIST);
        Iterator<BridgeStatus> iterator = bridgeStatuses.iterator();
        LineGenerator lineGenerator = new LineGenerator(iterator::next);
        Bridge bridge = lineGenerator.generate(5);

        List<BridgeStatus> testBridgeStatuses = bridge.getBridges();

        assertThat(testBridgeStatuses).containsExactly(EMPTY, EMPTY, EXIST, EMPTY);
    }
}
