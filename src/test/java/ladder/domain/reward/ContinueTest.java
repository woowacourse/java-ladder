package ladder.domain.reward;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ContinueTest {

    @Test
    @DisplayName("getContinue 테스트")
    void getContinueTest() {
        assertThat(Continue.getContinue("y")).isEqualTo(Continue.CONTINUE);
        assertThat(Continue.getContinue("Y")).isEqualTo(Continue.CONTINUE);
        assertThat(Continue.getContinue("n")).isEqualTo(Continue.STOP);
        assertThat(Continue.getContinue("N")).isEqualTo(Continue.STOP);
    }

    @ParameterizedTest(name = "input={0}")
    @DisplayName("getContinue 잘못된 문자 예외 테스트")
    @ValueSource(strings = {"x","1","o","no"})
    void getContinueWrongValueExceptionTest(String inputContinue) {
        assertThatThrownBy(() -> Continue.getContinue(inputContinue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "input={0}")
    @DisplayName("getContinue 공백 문자 예외 테스트")
    @ValueSource(strings = {" ","     ",""})
    void getContinueBlankExceptionTest(String inputContinue) {
        assertThatThrownBy(() -> Continue.getContinue(inputContinue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Continue getValue 테스트")
    void getValueTest() {
        assertThat(Continue.CONTINUE.getValue()).isEqualTo("Y");
        assertThat(Continue.STOP.getValue()).isEqualTo("N");
    }

}
