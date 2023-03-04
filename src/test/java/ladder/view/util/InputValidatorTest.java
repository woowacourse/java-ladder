package ladder.view.util;

import ladder.domain.ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputValidatorTest {

    @Test
    @DisplayName("validateContainName()은 결과를 원하는 사람의 이름이 존재하지 않을 시 오류가 발생한다.")
    void test_1() {
        //given & when
        List<String> namesList = List.of("coco", "fefe");
        String inputWantGameResults = "abc";

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateContainName(namesList, inputWantGameResults))
                .withMessage("해당하는 이름이 존재하지 않습니다.");
    }

    @DisplayName("validateLadderHeightRange()은 1~100 사이의 숫자가 아닐 시 오류가 발생한다.")
    @ParameterizedTest(name = "input : {0}")
    @ValueSource(ints = {-1, 101})
    void test_2(int input) {
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateLadderHeightRange(input))
                .withMessage("사다리 높이는 1이상 100 이하만 입력할 수 있습니다.");
    }

    @DisplayName("validateNonNumber()은 숫자인지 아닌지 판별해준다.")
    @ParameterizedTest(name = "input : {0}")
    @ValueSource(strings = {"a12", "12@"})
    void test_3(String input) {
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.validateNonNumber(input))
                .withMessage("숫자가 아닌 값은 입력할 수 없습니다.");
    }
}
