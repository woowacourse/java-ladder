package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PrizeTest {

    @DisplayName("5글자 이하면 생성 검증에 성공한다")
    @Test
    void testCreatePrizeValidateLength() {
        assertThatCode(() -> new Prize()).doesNotThrowAnyException();
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> new Prize());
    }

    @DisplayName("5글자를 초과하면 생성 검증에 실패한다")
    @Test
    void testCreatePrizeInvalidateLength() {

    }
}
