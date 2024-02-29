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
        PrizeName prizeName1 = new PrizeName("1");
        PrizeName prizeName2 = new PrizeName("2");

        Prizes prizes = new Prizes(List.of(prizeName1, prizeName2));
        assertThat(prizes.getPrizeCount()).isEqualTo(2);
    }

    @DisplayName("인덱스에 해당하는 결과를 가져올 수 있다")
    @Test
    void testGetPrize() {
        PrizeName prizeName1 = new PrizeName("1");
        PrizeName prizeName2 = new PrizeName("2");

        Prizes prizes = new Prizes(List.of(prizeName1, prizeName2));
        assertThat(prizes.getPrize(0)).isEqualTo("1");
    }
}
