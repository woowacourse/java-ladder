package model.prize;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PrizeTest {

    @DisplayName("실행 결과가 5자 이하이면 객체 생성 성공")
    @ParameterizedTest
    @ValueSource(strings = {"꽝", "5000", "3000", "식권", "맛있는커피"})
    void testValidLengthOfPrizeName(String name) {
        assertThatCode(() -> new Prize(name)).doesNotThrowAnyException();
    }

    @DisplayName("실행 결과가 5자 초과면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"꽝꽝꽝꽝꽝꽝", "100000", "돼지고기김치찌개"})
    void testInvalidLengthOfPrizeName(String name) {
        assertThatThrownBy(() -> new Prize(name))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
