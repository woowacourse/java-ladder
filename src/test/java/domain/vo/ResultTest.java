package domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    @DisplayName("글자 제한 실패 테스트")
    public void validateFailureTest() {
        //given
        String value1 = "";
        String value2 = "123456";

        //when
        //then
        assertThatThrownBy(() -> new Result(value1))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Result(value2))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("글자 제한 성공 테스트")
    public void validateSuccessTest() {
        //given
        String value1 = "1";
        String value2 = "12345";

        //when
        //then
        assertDoesNotThrow(() -> new Result(value1));
        assertDoesNotThrow(() -> new Result(value2));
    }

    @Test
    @DisplayName("동등성 비교 테스트")
    public void equalsTest() {
        //given
        String value = "value";
        Result target = new Result(value);

        //when
        boolean result = target.equals(new Result("value"));

        //then
        assertThat(result).isTrue();
    }
}