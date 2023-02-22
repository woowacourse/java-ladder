package ladder.domain;

import ladder.domain.prize.Prizes;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PrizesTest {

    @Test
    void Prizes_생성_테스트() {
        assertThatCode(() -> new Prizes(List.of("꽝", "성공")))
                .doesNotThrowAnyException();
    }
}
