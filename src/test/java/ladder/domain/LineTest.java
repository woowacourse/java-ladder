package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LineTest {

    @Test
    @DisplayName("BooleanGenerator가 TRUE 반환 시 연속되는 선이 없게 라인을 생성한다.")
    void generateTrueLineTest() {

        class IntendedBooleanGenerator implements BooleanGenerator {

            @Override
            public Boolean generate() {
                return Boolean.TRUE;
            }
        }

        BooleanGenerator booleanGenerator = new IntendedBooleanGenerator();

        Line line = new Line(3, booleanGenerator);
        List<ConnectionStatus> lineStatus = line.getLineStatus();

        Assertions.assertThat(lineStatus).containsExactly(ConnectionStatus.CONNECTED, ConnectionStatus.DISCONNECTED, ConnectionStatus.CONNECTED);
    }

    @Test
    @DisplayName("BooleanGenerator가 FALSE 반환 시 연속되는 선이 없게 라인을 생성한다.")
    void generateFalseLineTest() {

        class IntendedBooleanGenerator implements BooleanGenerator {

            @Override
            public Boolean generate() {
                return Boolean.FALSE;
            }
        }

        BooleanGenerator booleanGenerator = new IntendedBooleanGenerator();

        Line line = new Line(3, booleanGenerator);
        List<ConnectionStatus> lineStatus = line.getLineStatus();

        Assertions.assertThat(lineStatus).containsExactly(ConnectionStatus.DISCONNECTED, ConnectionStatus.DISCONNECTED, ConnectionStatus.DISCONNECTED);
    }
}
