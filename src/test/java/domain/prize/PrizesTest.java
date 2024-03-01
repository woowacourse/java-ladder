package domain.prize;

import static org.assertj.core.api.Assertions.assertThat;

import domain.ColumnPosition;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리 도착 결과들 일급 컬렉션 테스트")
class PrizesTest {

    @DisplayName("결과가 몇가지인지 알 수 있다")
    @Test
    void testCountPrize() {
        Prizes prizes = new Prizes(
                List.of(new Prize(new PrizeName("1"), new ColumnPosition(0)),
                        new Prize(new PrizeName("2"), new ColumnPosition(1))));

        assertThat(prizes.getPrizeCount()).isEqualTo(2);
    }

    @DisplayName("인덱스에 해당하는 결과를 가져올 수 있다")
    @Test
    void testGetPrize() {
        Prizes prizes = new Prizes(
                List.of(new Prize(new PrizeName("1"), new ColumnPosition(0)),
                        new Prize(new PrizeName("2"), new ColumnPosition(1))));

        Prize prize = prizes.getPrize(new ColumnPosition(0));
        assertThat(prize.getPrizeName()).isEqualTo("1");
    }
}
