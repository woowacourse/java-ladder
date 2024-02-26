package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리 도착 결과들 일급 컬렉션 테스트")
class PrizesTest {

    @DisplayName("결과가 몇가지인지 알 수 있다")
    @Test
    void testCountPrize() {
        Prize prize1 = new Prize("1");
        Prize prize2 = new Prize("2");

        Prizes prizes = new Prizes(List.of(prize1, prize2));
        assertThat(prizes.getPrizeCount()).isEqualTo(2);
    }

    @DisplayName("인덱스에 해당하는 결과를 가져올 수 있다")
    @Test
    void testGetPrize() {
        Prize prize1 = new Prize("1");
        Prize prize2 = new Prize("2");

        Prizes prizes = new Prizes(List.of(prize1, prize2));
        assertThat(prizes.getPrize(0)).isEqualTo("1");
    }
}
