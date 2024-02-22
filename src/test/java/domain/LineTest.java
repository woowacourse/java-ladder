package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.TestLadderItemGenerator;
import java.util.List;
import java.util.stream.Stream;

class LineTest {

    @DisplayName("현재 위치에서 다리를 놓을 수 있는지 확인")
    @ParameterizedTest
    @MethodSource("methodSourceEnum")
    void checkIsPossibleAddBridgeTest(LadderItem actual, LadderItem isConnectable, LadderItem expected) {
        Line line = new Line(5);
        line.getPoints().add(actual);

        assertThat(line.decideConnectable(1, isConnectable)).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSourceEnum() {
        return Stream.of(
                Arguments.arguments(LadderItem.CONNECTED, LadderItem.CONNECTED, LadderItem.UNCONNECTED),
                Arguments.arguments(LadderItem.UNCONNECTED, LadderItem.CONNECTED, LadderItem.CONNECTED)
        );
    }

    @DisplayName("사다리 라인 생성")
    @Test
    void makeLineTest() {
        TestLadderItemGenerator testDirectionGenerator = new TestLadderItemGenerator(LadderItem.CONNECTED);
        Line line = new Line(4);

        assertThat(line.makeLine(testDirectionGenerator)).isEqualTo(List.of(LadderItem.CONNECTED, LadderItem.UNCONNECTED, LadderItem.CONNECTED));
    }
}