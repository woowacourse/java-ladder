package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @DisplayName("한 라인에 연속되는 다리는 존재하지 않는다")
    @Test
    public void createNotContinuouslyBridge() {
        Line line = new Line(4, new FixedBridgeGenerator());
        Map<Integer, Bridge> bridges = line.getBridges();

        Bridge bridge1 = bridges.get(0);
        Bridge bridge2 = bridges.get(1);
        Bridge bridge3 = bridges.get(2);

        assertAll(
                () -> assertThat(bridge1).isEqualTo(Bridge.EXIST),
                () -> assertThat(bridge2).isEqualTo(Bridge.BLANK),
                () -> assertThat(bridge3).isEqualTo(Bridge.EXIST)
        );
    }

    @DisplayName("플레이어의 인덱스와 Bridge를 계산하여 위치를 반환한다")
    @Test
    public void calculatePosition() {
        int playersCount = 4;
        Line line = new Line(playersCount, new FixedBridgeGenerator());

        /*
         0     1     2     3
         |-----|     |-----|
         1     0     3     2
         */
        assertThat(line.calculatePosition(0)).isEqualTo(1);
        assertThat(line.calculatePosition(1)).isEqualTo(0);
        assertThat(line.calculatePosition(2)).isEqualTo(3);
        assertThat(line.calculatePosition(3)).isEqualTo(2);
    }
}
