package ladder.domain.reward;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ContinueTest {

    @ParameterizedTest(name = "input={0}")
    @DisplayName("getContinue 테스트")
    @ValueSource(strings = {"y","n","Y","N"})
    void createContinueTest(String inputContinue) {
        assertDoesNotThrow(() -> getContinue(inputContinue));
    }

    @ParameterizedTest(name = "input={0}")
    @DisplayName("getContinue 생성 잘못된 문자 예외 테스트")
    @ValueSource(strings = {"x","1","o","no"})
    void createContinueTest(String inputContinue) {
        assertThatThrownBy(() -> getContinue(inputContinue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "input={0}")
    @DisplayName("Continue 생성 공백 문자 예외 테스트")
    @ValueSource(strings = {" ","     ",""})
    void createContinueTest(String inputContinue) {
        assertThatThrownBy(() -> getContinue(inputContinue))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
