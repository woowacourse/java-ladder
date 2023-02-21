package ladder.domain.strategy.linestrategy;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResultTest {

    @ParameterizedTest
    @DisplayName("이름이 공백이면 IllegalArgumentException 예외가 발생한다.")
    @ValueSource(strings = {"", " ", "\n", "    "})
    void create_blank(String input) {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Result(input)
        ).withMessage("[ERROR] 결과는 공백일 수 없습니다.");
     }
}
