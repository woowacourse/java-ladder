package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.generator.BridgeGenerator;
import domain.generator.FixedBridgeGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FixedBridgeGeneratorTest {

    @DisplayName("이전 다리가 존재하면 연결된 다리를 반환하지 않는다")
    @Test
    public void createBlankBridgeWhenPreviousBridgeExist() {
        BridgeGenerator bridgeGenerator = new FixedBridgeGenerator();

        Bridge generatedBridge = bridgeGenerator.generate(Bridge.EXIST);

        assertThat(generatedBridge).isEqualTo(Bridge.BLANK);
    }
}
