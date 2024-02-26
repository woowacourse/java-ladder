package model.prize;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizeTest {
    @DisplayName("실행 결과가 5자 이하이면 객체 생성 성공")
    @ParameterizedTest
    @CsvSource({"꽝", "5000", "3000", "식권", "맛있는커피"})
    void testValidLengthOfPrizeName(String name) {
        assertThatCode(() -> new Prize(name)).doesNotThrowAnyException();
    }
}
