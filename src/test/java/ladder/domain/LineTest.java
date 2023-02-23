package ladder.domain;

import java.util.List;

import ladder.utils.BooleanGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LineTest {

    private BooleanGenerator booleanGenerator;

    class TrueGenerator implements BooleanGenerator {

        @Override
        public Boolean generate() {
            return Boolean.TRUE;
        }
    }

    class FalseGenerator implements BooleanGenerator {

        @Override
        public Boolean generate() {
            return Boolean.FALSE;
        }
    }


    private void generateFalseGenerator() {
        this.booleanGenerator = new FalseGenerator();
    }

    private void generateTrueGenerator() {
        this.booleanGenerator = new TrueGenerator();
    }

    @Test
    @DisplayName("BooleanGenerator가 TRUE 반환 시 연속되는 선이 없게 라인을 생성한다.")
    void generateTrueLineTest() {
        generateTrueGenerator();

        Line line = new Line(3, booleanGenerator);
        List<ConnectionStatus> lineStatus = line.getLineStatus();

        Assertions.assertThat(lineStatus).containsExactly(ConnectionStatus.CONNECTED, ConnectionStatus.DISCONNECTED, ConnectionStatus.CONNECTED);
    }

    @Test
    @DisplayName("BooleanGenerator가 FALSE 반환 시 연속되는 선이 없게 라인을 생성한다.")
    void generateFalseLineTest() {
        generateFalseGenerator();

        Line line = new Line(3, booleanGenerator);
        List<ConnectionStatus> lineStatus = line.getLineStatus();

        Assertions.assertThat(lineStatus).containsExactly(ConnectionStatus.DISCONNECTED, ConnectionStatus.DISCONNECTED, ConnectionStatus.DISCONNECTED);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,0", "2,3", "3,2"})
    @DisplayName("시작 위치를 받아서 선 연결 유무에 따라 도착 위치를 반환한다. (TrueGenerator)")
    void moveTrueGeneratorTest(int startIndex, int endIndex) {
        generateTrueLineTest();
        Line line = new Line(3, booleanGenerator);

        Assertions.assertThat(line.indicateNextIndex(startIndex)).isEqualTo(endIndex);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,1", "2,2", "3,3"})
    @DisplayName("시작 위치를 받아서 선 연결 유무에 따라 도착 위치를 반환한다. (FalseGenerator)")
    void moveFalseGeneratorTest(int startIndex, int endIndex) {
        generateFalseLineTest();
        Line line = new Line(3, booleanGenerator);

        Assertions.assertThat(line.indicateNextIndex(startIndex)).isEqualTo(endIndex);
    }
}
