package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.TestLadderItemGenerator;
import view.LadderItem;

import java.util.List;
import java.util.stream.Stream;

class LineTest {

    private static Stream<Arguments> methodSourceEnum() {
        return Stream.of(
                Arguments.arguments(LadderItem.CONNECTED, List.of(LadderItem.CONNECTED, LadderItem.UNCONNECTED, LadderItem.CONNECTED)),
                Arguments.arguments(LadderItem.UNCONNECTED, List.of(LadderItem.UNCONNECTED, LadderItem.UNCONNECTED, LadderItem.UNCONNECTED))
        );
    }

    @DisplayName("사다리 라인 생성")
    @ParameterizedTest
    @MethodSource("methodSourceEnum")
    void makeLineTest(LadderItem actual, List<LadderItem> expected) {
        TestLadderItemGenerator testDirectionGenerator = new TestLadderItemGenerator(actual);
        Line line = new Line(4);

        assertThat(line.makeLine(testDirectionGenerator)).isEqualTo(expected);
    }
}