package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    @DisplayName("Result는 결과 이름을 넣어 생성할 수 있다.")
    void resultTest() {
        Result result = new Result("실행 결과");

        Assertions.assertThat(result.getResultName()).isEqualTo("실행 결과");
    }
}
