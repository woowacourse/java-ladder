package domain.ladder;

import domain.generator.MockBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static domain.ladder.Bridge.BLOCKED;
import static domain.ladder.Bridge.PASSABLE;
import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    MockBooleanGenerator booleanGenerator;

    @Test
    @DisplayName("Line의 크기는 참가자 수 - 1 이다")
    void validateBridgeSize_Success() {
        booleanGenerator = new MockBooleanGenerator(createRandomFlag(5));
        Line line = new Line(5, booleanGenerator);
        assertThat(line.getBridges().size()).isEqualTo(4);
    }

    @ParameterizedTest
    @MethodSource("generateFlag")
    @DisplayName("가로 라인이 겹치지 않도록 참가자 수에 따라 Line을 생성한다.")
    void createLine(int personCount, List<Boolean> inputFlag, List<Bridge> expected) {
        booleanGenerator = new MockBooleanGenerator(inputFlag);
        Line line = new Line(personCount, booleanGenerator);

        assertThat(line.getBridges()).isEqualTo(expected);
    }


    private static Stream<Arguments> generateFlag() {
        return Stream.of(
                Arguments.arguments(2, List.of(true), List.of(PASSABLE)),
                Arguments.arguments(3, List.of(true, false), List.of(PASSABLE, BLOCKED)),
                Arguments.arguments(4, List.of(false, true, true), List.of(BLOCKED, PASSABLE, BLOCKED)),
                Arguments.arguments(5, List.of(false, false, false, false), List.of(BLOCKED, BLOCKED, BLOCKED, BLOCKED)),
                Arguments.arguments(6, List.of(true, true, true, true, true), List.of(PASSABLE, BLOCKED, PASSABLE, BLOCKED, PASSABLE))
        );
    }

    private List<Boolean> createRandomFlag(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> true)
                .collect(Collectors.toList());
    }
}
