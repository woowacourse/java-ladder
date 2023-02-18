package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserNameTest {

    private static final String COMMAND_ALL = "all";

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "여섯글자이름"})
    @DisplayName("유저 이름은 공백이거나 여섯 글자 이상일 수 없다.")
    void userNameExceptionTest(String value) {
        assertThatThrownBy(() -> new UserName(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("초과");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "다섯글자임", "  공백제외5  "})
    @DisplayName("유저 이름 유효성 검증 경계값을 검증하는 테스트")
    void validNameTest(String value) {
        assertThatCode(() -> new UserName(value))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("유저 이름은 all 일 수 없다.")
    void notAllTest() {
        assertThatThrownBy(() -> new UserName(COMMAND_ALL))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(COMMAND_ALL);
    }
}
