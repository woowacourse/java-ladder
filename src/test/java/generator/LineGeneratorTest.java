package generator;

import domain.Bridge;
import domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static domain.Bridge.EMPTY;
import static domain.Bridge.EXIST;
import static org.assertj.core.api.Assertions.assertThat;

class LineGeneratorTest {

    private final BridgeGenerator existBridgeGenerator = () -> EXIST;

    @Test
    @DisplayName("절대 겹쳐지지 않는 Line이 만들어진다.")
    void test_Line_never_overlapped() {
        LineGenerator lineGenerator = new LineGenerator(existBridgeGenerator);
        Line line = lineGenerator.generate(7);

        List<Bridge> bridges = line.getBridges();

        assertThat(bridges).containsExactly(EXIST, EMPTY, EXIST, EMPTY, EXIST, EMPTY);
    }

    @Test
    @DisplayName("[경계값 테스트] 절대 겹쳐지지 않는 Line이 만들어진다.")
    void test_Line_never_overlapped_boundary() {
        LineGenerator lineGenerator = new LineGenerator(existBridgeGenerator);
        Line line = lineGenerator.generate(2);

        List<Bridge> bridges = line.getBridges();

        assertThat(bridges).containsExactly(EXIST);
    }

    @Test
    @DisplayName("[실제 예시 테스트] 절대 겹쳐지지 않는 Line이 만들어진다.")
    void test_Line_never_overlapped_sample() {
        List<Bridge> providedBridges = List.of(EMPTY, EMPTY, EXIST, EXIST);
        Iterator<Bridge> bridgeIterator = providedBridges.iterator();
        LineGenerator lineGenerator = new LineGenerator(bridgeIterator::next);
        Line line = lineGenerator.generate(5);

        List<Bridge> generatedBridges = line.getBridges();

        assertThat(generatedBridges).containsExactly(EMPTY, EMPTY, EXIST, EMPTY);
    }
}
