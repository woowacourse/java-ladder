package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.LineTest.FixedBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    @DisplayName("true면 EXIST를 생성한다.")
    void createBridgeByTrue() {
        assertThat(Bridge.of(new FixedBooleanGenerator(true))).isEqualTo(Bridge.EXIST);
    }

    @Test
    @DisplayName("false면 BLANK를 생성한다.")
    void createBridgeByFalse() {
        assertThat(Bridge.of(new FixedBooleanGenerator(false))).isEqualTo(Bridge.BLANK);
    }

}