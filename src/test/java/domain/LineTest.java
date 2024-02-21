package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.TestBooleanGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("현재 위치에서 다리를 놓을 수 있는지에 대한 여부")
    @ParameterizedTest
    @CsvSource(value = {"true,false", "false,true"}, delimiter = ',')
    void checkIsPossibleAddBridgeTest(boolean isConnectable, boolean expected) {
        // given
        Line line = new Line(5);
        line.getPoints().add(isConnectable);

        // when
        assertThat(line.checkIsPossibleAddBridge(1)).isEqualTo(expected);
    }

    @DisplayName("라인 생성 테스트")
    @Test
    void makeLineTest() {
        TestBooleanGenerator testDirectionGenerator = new TestBooleanGenerator(Boolean.TRUE);
        Line line = new Line(4);

        assertThat(line.makeLine(testDirectionGenerator)).isEqualTo(List.of(true, false, true));
    }
}