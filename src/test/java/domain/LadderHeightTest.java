package domain;

import domain.ladder.LadderHeight;
import exception.ladder.InvalidLadderHeightException;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class LadderHeightTest {

    @DisplayName("사다리 높이가 요구사항에 부합한 경우")
    @TestFactory
    Stream<DynamicTest> createSuccess() {
        return Stream.of(
            DynamicTest.dynamicTest("높이가 1인 경우", () -> {
                LadderHeight ladderHeight = new LadderHeight("1");
                Assertions.assertThat(ladderHeight.getHeight()).isEqualTo(1);
            }),
            DynamicTest.dynamicTest("높이가 10인 경우", () -> {
                LadderHeight ladderHeight = new LadderHeight("10");
                Assertions.assertThat(ladderHeight.getHeight()).isEqualTo(10);
            })
        );
    }

    @DisplayName("사다리 높이가 요구사항에 맞지 않는 경우")
    @TestFactory
    Stream<DynamicTest> createFail() {
        return Stream.of(
            DynamicTest.dynamicTest("높이가 null 인 경우.",
                () -> Assertions.assertThatThrownBy(() -> new LadderHeight(null))
                    .isExactlyInstanceOf(InvalidLadderHeightException.class)),
            DynamicTest.dynamicTest("높이가 빈문자열 이루어진 경우.",
                () -> Assertions.assertThatThrownBy(() -> new LadderHeight(""))
                    .isExactlyInstanceOf(InvalidLadderHeightException.class)),
            DynamicTest.dynamicTest("높이가 공백으로 이루어진 경우.",
                () -> Assertions.assertThatThrownBy(() -> new LadderHeight("     "))
                    .isExactlyInstanceOf(InvalidLadderHeightException.class)),
            DynamicTest.dynamicTest("높이가 정수가 아닌 경우.",
                () -> Assertions.assertThatThrownBy(() -> new LadderHeight("as"))
                    .isExactlyInstanceOf(InvalidLadderHeightException.class)),
            DynamicTest.dynamicTest("높이가 음수인 경우.",
                () -> Assertions.assertThatThrownBy(() -> new LadderHeight("-1"))
                    .isExactlyInstanceOf(InvalidLadderHeightException.class)),
            DynamicTest.dynamicTest("높이가 0인 경우.",
                () -> Assertions.assertThatThrownBy(() -> new LadderHeight("0"))
                    .isExactlyInstanceOf(InvalidLadderHeightException.class)),
            DynamicTest.dynamicTest("높이가 11인 경우.",
                () -> Assertions.assertThatThrownBy(() -> new LadderHeight("11"))
                    .isExactlyInstanceOf(InvalidLadderHeightException.class))
        );
    }
}

