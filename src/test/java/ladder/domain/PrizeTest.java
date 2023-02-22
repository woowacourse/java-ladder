package ladder.domain;

import ladder.domain.prize.Prize;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class PrizeTest {

    @Test
    void 결과_생성_테스트() {
        String name = "꽝";
        assertThatCode(() -> new Prize(name))
                .doesNotThrowAnyException();
    }
}