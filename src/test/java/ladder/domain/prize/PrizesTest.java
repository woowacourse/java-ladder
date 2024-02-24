package ladder.domain.prize;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizesTest {
    @Test
    @DisplayName("Prizes 객체 생성 테스트")
    void createPrizes() {
        List<String> prizeNames = List.of("꽝", "5000", "꽝", "3000");
        Prizes prizes = Prizes.of(prizeNames, 4);

        assertThat(prizes.getPrizes()).containsExactly(
                new Prize("꽝"),
                new Prize("5000"),
                new Prize("꽝"),
                new Prize("3000")
        );
    }

    @Test
    @DisplayName("참여자 수와 상품 수가 다를 경우 예외를 발생한다.")
    void testDifferentSize() {
        List<String> prizeNames = List.of("꽝", "5000", "꽝", "3000");
        assertThatThrownBy(() -> Prizes.of(prizeNames, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
