package domain;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import exception.EmpytInputException;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

class LaddersResultTest {

    @DisplayName("사다리 결과가 요구사항에 충족할 경우")
    @Test
    void createSuccess() {
        LadderResults ladderResult = new LadderResults("1000,5000");
        List<String> results = ladderResult.getResults();
        Assertions.assertThat(results).hasSize(2);
        Assertions.assertThat(results).containsExactly("1000", "5000");
    }

    @DisplayName("사다리 결과가 요구사항에 맞지 않는 경우")
    @TestFactory
    Stream<DynamicTest> createFail() {
        return Stream.of(
            dynamicTest("결과가 null인 경우", () -> Assertions.assertThatThrownBy(() -> new LadderResults(null))
                .isExactlyInstanceOf(EmpytInputException.class)),
            dynamicTest("결과가 빈문자열인 경우", () -> Assertions.assertThatThrownBy(() -> new LadderResults(""))
                .isExactlyInstanceOf(EmpytInputException.class)),
            dynamicTest("결과가 공백으로 이루어져 있는 경우", () -> Assertions.assertThatThrownBy(() -> new LadderResults("    "))
                .isExactlyInstanceOf(EmpytInputException.class))
        );
    }
}
