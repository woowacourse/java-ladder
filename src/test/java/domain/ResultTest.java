package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Assertions.assertThatCode(() -> new Result())
                .doesNotThrowAnyException();
    }
}
