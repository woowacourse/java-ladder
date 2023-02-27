package ladder.domain;

import ladder.common.CustomException;
import ladder.domain.result.Results;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultsTest {

    @Test
    void Prizes_생성_테스트() {
        int playerCount = 2;

        assertThatCode(() -> Results.of(playerCount, List.of("꽝", "성공")))
                .doesNotThrowAnyException();
    }

    @Test
    void 결과_수가_플레이어_수와_같지_않으면_예외_발생() {
        int playerCount = 4;

        assertThatThrownBy(() -> Results.of(playerCount, List.of("1", "2", "3", "4", "5")))
                .isInstanceOf(CustomException.class);
    }
}
