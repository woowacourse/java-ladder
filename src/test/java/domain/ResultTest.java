package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    @DisplayName("사다리 결과를 생성한다.")
    void createResult() {
        //given
        //when
        //then
        Assertions.assertThatCode(() -> new Result("꽝"))
                .doesNotThrowAnyException();
    }

}
