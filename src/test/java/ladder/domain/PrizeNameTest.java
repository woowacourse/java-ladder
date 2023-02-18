package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "여섯글자이름"})
    @DisplayName("상품 이름은 공백이거나 여섯 글자 이상일 수 없다.")
    void userNameExceptionTest(String value) {
        assertThatThrownBy(() -> new UserName(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "다섯글자임", "  공백제외5  "})
    @DisplayName("상품 이름 유효성 검증 경계값을 검증하는 테스트")
    void validNameTest(String value) {
        assertThatCode(() -> new UserName(value))
                .doesNotThrowAnyException();
    }
}
