package domain;

import exception.InvalidLineWeightException;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import util.RandomBooleanGenerator;

class LineTest {

    @DisplayName("라인의 너비가 조건에 맞는 경우")
    @TestFactory
    Stream<DynamicTest> createSuccess() {
        return Stream.of(
            DynamicTest.dynamicTest("라인의 너비가 1인 경우(최소)", () -> {
                Line line = new Line(1, () -> false);
                List<Boolean> blocks = line.getBlocks();
                Assertions.assertThat(blocks.size()).isEqualTo(1);
                Assertions.assertThat(blocks).containsExactly(false);
            }),
            DynamicTest.dynamicTest("라인의 너비가 9인 경우(최대)", () -> {
                Line line = new Line(9, () -> true);
                List<Boolean> blocks = line.getBlocks();
                Assertions.assertThat(blocks.size()).isEqualTo(9);
                Assertions.assertThat(blocks).containsExactly(true, false, true, false, true, false, true, false, true);
            })
        );
    }

    @DisplayName("라인의 너비가 조건에 맞지 않는경우")
    @TestFactory
    Stream<DynamicTest> createFail() {
        return Stream.of(
            DynamicTest.dynamicTest("라인의 너비가 0인 경우",
                () -> Assertions.assertThatThrownBy(() -> new Line(0, new RandomBooleanGenerator()))
                    .isExactlyInstanceOf(InvalidLineWeightException.class)),
            DynamicTest.dynamicTest("라인의 너비가 10인 경우",
                () -> Assertions.assertThatThrownBy(() -> new Line(10, new RandomBooleanGenerator()))
                    .isExactlyInstanceOf(InvalidLineWeightException.class))
        );
    }
}
