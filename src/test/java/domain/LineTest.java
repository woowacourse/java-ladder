package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import domain.generator.FixedBridgeGenerator;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("라인을 생성한다")
    @Test
    public void create() {
        assertThatCode(() -> new Line(4, new FixedBridgeGenerator()))
                .doesNotThrowAnyException();
    }

    @DisplayName("플레이어의 수 - 1 만큼 Bridge를 가진다")
    @Test
    public void createBridgesCountByPlayersCountMinusOne() {
        Line line = new Line(4, new FixedBridgeGenerator());

        Map<Integer, Bridge> bridges = line.getBridges();

        assertThat(bridges.size()).isEqualTo(3);
    }
}
