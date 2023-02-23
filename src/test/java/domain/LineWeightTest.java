package domain;

import domain.ladder.LadderHeight;
import domain.ladder.LineWeight;
import exception.ladder.InvalidLineWeightException;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class LineWeightTest {

    @DisplayName("라인의 너비가 요구사항에 부합한 경우")
    @TestFactory
    Stream<DynamicTest> createSuccess() {
        return Stream.of(
            DynamicTest.dynamicTest("너비가 1인 경우", () -> {
                LadderHeight ladderHeight = new LadderHeight("1");
                Assertions.assertThat(ladderHeight.getHeight()).isEqualTo(1);
            }),
            DynamicTest.dynamicTest("너비가 9인 경우", () -> {
                LadderHeight ladderHeight = new LadderHeight("9");
                Assertions.assertThat(ladderHeight.getHeight()).isEqualTo(9);
            })
        );
    }

    @DisplayName("라인의 너비가 요구사항에 맞지 않는 경우")
    @TestFactory
    Stream<DynamicTest> createFail() {
        return Stream.of(
            DynamicTest.dynamicTest("너비가 음수인 경우.",
                () -> Assertions.assertThatThrownBy(() -> new LineWeight(-1))
                    .isExactlyInstanceOf(InvalidLineWeightException.class)),
            DynamicTest.dynamicTest("너비가 0 인 경우.",
                () -> Assertions.assertThatThrownBy(() -> new LineWeight(0))
                    .isExactlyInstanceOf(InvalidLineWeightException.class)),
            DynamicTest.dynamicTest("너비가 10 경우.",
                () -> Assertions.assertThatThrownBy(() -> new LineWeight(10))
                    .isExactlyInstanceOf(InvalidLineWeightException.class))
        );
    }
}
