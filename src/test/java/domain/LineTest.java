package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.TestLineItemGenerator;
import java.util.List;
import java.util.stream.Stream;

class LineTest {

    @DisplayName("현재 위치에서 LineItem을 놓을 수 있는지 확인한다.")
    @ParameterizedTest
    @MethodSource("methodSourceEnum")
    void checkCanAddLineItem(LineItem actual, LineItem lineItem, LineItem expected) {
        Line line = new Line(5);
        line.getPoints().add(actual);

        assertThat(line.decideLineItem(1, lineItem)).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSourceEnum() {
        return Stream.of(
                Arguments.arguments(LineItem.CONNECTED, LineItem.CONNECTED, LineItem.UNCONNECTED),
                Arguments.arguments(LineItem.UNCONNECTED, LineItem.CONNECTED, LineItem.CONNECTED)
        );
    }

    @DisplayName("사다리의 Line이 올바르게 생성되는지 확인한다.")
    @Test
    void checkCreatedLineIsCorrect() {
        TestLineItemGenerator testDirectionGenerator = new TestLineItemGenerator(LineItem.CONNECTED);
        Line line = new Line(4);

        assertThat(line.makeLine(testDirectionGenerator))
                .isEqualTo(List.of(LineItem.CONNECTED, LineItem.UNCONNECTED, LineItem.CONNECTED));
    }
}
