package domain;

import constant.domain.ResultExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultTest {

    @Test
    @DisplayName("결과의 개수가 참여자의 인원수와 다르면 예외가 발생한다.")
    void numberOfPrizeExceptionTest() {
        List<String> prizes = List.of("꽝", "5000", "꽝");

        assertThatThrownBy(() -> new Result(prizes, 4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ResultExceptionMessage.NOT_SAME_COUNT.getExceptionMessage());
    }

    @Test
    @DisplayName("원하는 위치의 결과를 가져올 수 있다.")
    void getPrizeAtTest() {
        List<String> prizes = List.of("1", "10", "100", "1000");
        Result prize = new Result(prizes, 4);

        assertAll(() -> assertEquals(prize.getPrizeOf(0), new Prize("1")),
                () -> assertEquals(prize.getPrizeOf(1), new Prize("10")),
                () -> assertEquals(prize.getPrizeOf(2), new Prize("100")),
                () -> assertEquals(prize.getPrizeOf(3), new Prize("1000")));
    }

}
