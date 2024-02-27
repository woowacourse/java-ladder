package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizesTest {

    @DisplayName("상품 생성 테스트")
    @Test
    void createPrizeTest() {
        Prizes prizes = new Prizes(new ArrayList<>(List.of("꽝", "3000", "꽝", "5000")), 4);
    }

    @DisplayName("상품의 개수가 참여자 인원수와 일치하지 않을 경우 예외를 발생한다.")
    @Test
    void validatePrizesCountTest() {
        Assertions.assertThatThrownBy(() -> new Prizes(new ArrayList<>(List.of("꽝", "30000", "3000")), 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품의 개수는 참여자 인원수와 일치해야 합니다.");

    }
}
