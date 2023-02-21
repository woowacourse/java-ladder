package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    @DisplayName("실행 결과가 올바를 경우 생성된 Result가 입력된 값과 같은 값을 가지는지 확인한다.")
    void generateResultTest() {
        final String validResultName = "꽝";
        final Result result = new Result(validResultName);
        assertThat(result.getName()).isEqualTo(validResultName);
    }
}
