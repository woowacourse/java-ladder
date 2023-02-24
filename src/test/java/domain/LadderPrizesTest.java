package domain;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import domain.ladder.LadderPrizes;
import exception.ladder.InvalidLadderResultCount;
import exception.view.EmptyInputException;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

class LadderPrizesTest {

    @DisplayName("사다리 결과들의 입력값이 요구사항에 충족할 경우")
    @Test
    void createSuccess() {
        LadderPrizes ladderPrizes = LadderPrizes.valueOf("1000,5000", 2);
        List<String> results = ladderPrizes.getResultNames();
        Assertions.assertThat(results).hasSize(2);
        Assertions.assertThat(results).containsExactly("1000", "5000");
    }

    @DisplayName("사다리 결과들의 입력값이 요구사항에 맞지 않는 경우")
    @TestFactory
    Stream<DynamicTest> createFail() {
        return Stream.of(
            dynamicTest("결과가 null인 경우",
                () -> Assertions.assertThatThrownBy(() -> LadderPrizes.valueOf(null, 1))
                    .isExactlyInstanceOf(EmptyInputException.class)),
            dynamicTest("결과가 빈문자열인 경우",
                () -> Assertions.assertThatThrownBy(() -> LadderPrizes.valueOf("", 1))
                    .isExactlyInstanceOf(EmptyInputException.class)),
            dynamicTest("결과가 공백으로 이루어져 있는 경우",
                () -> Assertions.assertThatThrownBy(() -> LadderPrizes.valueOf("    ", 1))
                    .isExactlyInstanceOf(EmptyInputException.class)),
            dynamicTest("결과의 갯수와 참가자의 수가 다른 경우",
                () -> Assertions.assertThatThrownBy(() -> LadderPrizes.valueOf("split,jamie", 3))
                    .isExactlyInstanceOf(InvalidLadderResultCount.class))
        );
    }
}
