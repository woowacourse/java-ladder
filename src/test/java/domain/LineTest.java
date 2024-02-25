package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import util.TestBooleanGenerator;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    private static Stream<Arguments> methodSourceEnum() {
        return Stream.of(
                Arguments.arguments(true, List.of(LadderItem.CONNECTED, LadderItem.UNCONNECTED, LadderItem.CONNECTED)),
                Arguments.arguments(false, List.of(LadderItem.UNCONNECTED, LadderItem.UNCONNECTED, LadderItem.UNCONNECTED))
        );
    }

    @DisplayName("사다리 라인 생성")
    @ParameterizedTest
    @MethodSource("methodSourceEnum")
    void makeLineTest(boolean actual, List<LadderItem> expected) {
        TestBooleanGenerator testDirectionGenerator = new TestBooleanGenerator(actual);
        Line line = new Line(4);

        assertThat(line.makeLine(testDirectionGenerator)).isEqualTo(expected);
    }

    @DisplayName("라인 상에서 이동 결과 탐색")
    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,0", "2,3", "3,2"}, delimiter = ',')
    void getLineResultTest(int actual, int expected) {
        TestBooleanGenerator testtestBooleanGenerator = new TestBooleanGenerator(true);
        Line line = new Line(4);
        line.makeLine(testtestBooleanGenerator);

        assertThat(line.decideNextPosition(actual)).isEqualTo(expected);
    }
}