package domain.prize;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PrizeTest {

    @DisplayName("5글자 이하면 생성 검증에 성공한다")
    @ValueSource(strings = {"1", "12345"})
    @ParameterizedTest
    void testCreatePrizeValidateLength(String prizeName) {
        assertDoesNotThrow(() -> new Prize(prizeName));
    }

    @DisplayName("5글자를 초과하면 생성 검증에 실패한다")
    @ValueSource(strings = {"", "123456"})
    @ParameterizedTest
    void testCreatePrizeInvalidateLength(String prizeName) {
        Assertions.assertThatThrownBy(() -> new Prize(prizeName))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 상품 이름의 길이는 1 ~ 5 글자여야 합니다.");
    }
}
