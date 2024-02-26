package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizeTest {

    @Test
    @DisplayName("결과의 개수가 참여자의 인원수와 다르면 예외가 발생한다.")
    void numberOfPrizeExceptionTest() {
        List<String> prizes = List.of("꽝", "5000", "꽝");

        assertThatThrownBy(() -> new Prize(prizes, 4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과의 개수가 참여자의 인원수와 다릅니다.");
    }

    @Test
    @DisplayName("원하는 위치의 결과를 가져올 수 있다.")
    void getPrizeAtTest() {
        List<String> prizes = List.of("1", "100", "1000", "10000");
        Prize prize = new Prize(prizes, 4);

        assertThat(prize.getPrizeOf(0)).isEqualTo("1");
        assertThat(prize.getPrizeOf(1)).isEqualTo("10");
        assertThat(prize.getPrizeOf(2)).isEqualTo("100");
        assertThat(prize.getPrizeOf(3)).isEqualTo("1000");
    }

}
