package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultTest {

    @Test
    @DisplayName("결과의 개수가 참여자의 인원수와 다르면 예외가 발생한다.")
    void numberOfPrizeExceptionTest() {
        List<String> prizes = List.of("꽝", "5000", "꽝");

        assertThatThrownBy(() -> new Result(prizes, 4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Result.NOT_SAME_COUNT);
    }

}
