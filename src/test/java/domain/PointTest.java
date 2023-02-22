package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PointTest {

    @ParameterizedTest(name = "left, right가 모두 true가 아니면 생성에 성공한다.")
    @CsvSource({"true,false", "false, true", "false,false"})
    void pointGenerateSuccessTest(boolean left, boolean right) {
        assertThatCode(() -> new Point(left, right))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("left, right가 모두 true이면, point생성에 실패한다.")
    void pointGenerateFailTest() {
        assertThatThrownBy(() -> new Point(true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
