package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultTest {

    @Test
    @DisplayName("6자 미만 문자열이 입력될 경우 문자열을 포장한 Result 객체가 생성된다.")
    void makeResultUsingLessThan6CharactersAsInput() {

        String result = "꽝";

        Assertions.assertDoesNotThrow(() -> new Result(result));
    }

    @Test
    @DisplayName("5자 초과 문자열이 입력될 경우 예외처리가 발생한다")
    void throwExceptionUsingMoreThan5CharactersAsInput() {

        String result = "꽝일까아닐까";

        assertThatThrownBy(() -> new Result(result))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값은 6자를 초과할 수 없습니다.");
    }
}
