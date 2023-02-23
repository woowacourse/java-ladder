package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class ResultsTest {

    @Test
    @DisplayName("참여자 수 만큼 입력되지 않으면 예외 처리")
    void test() {
        Assertions.assertThatThrownBy(() -> new Results(3, List.of("꽝,꽝")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Results.SIZE_ERROR);
    }

}