package ladder.domain;

import ladder.domain.result.Result;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    @DisplayName("결과가 5글자 이상이라면 예외가 발생한다.")
    void resultLengthExceptionTest() {
        Assertions.assertThatThrownBy(
                () -> new Result("긴결과입니다")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
