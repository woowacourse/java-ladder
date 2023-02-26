package domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    @DisplayName("적절하지 않은 길이의 문자가 들어왔을 때를 테스트")
    public void testInvalidLengthString() {
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
    @DisplayName("적절한 길이의 문자가 들어왔을 때를 테스트")
    public void testvalidLengthString() {
        //given
        String value1 = "1";
        String value2 = "12345";

        //when
        //then
        assertDoesNotThrow(() -> new Result(value1));
        assertDoesNotThrow(() -> new Result(value2));
    }
}
