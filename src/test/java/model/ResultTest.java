package model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    @DisplayName("정상적으로 실행 결과 객체를 생성한다.")
    void createResult() {
        List<String> values = List.of("꽝", "5000", "꽝", "1000");
        Assertions.assertThatCode(() -> Result.from(values))
                .doesNotThrowAnyException();
    }
}
