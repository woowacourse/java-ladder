package ladder.domain.resource.prize;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizesTest {

    @DisplayName("당첨품의 수가 2개 미만인 경우 예외가 발생한다.")
    @Test
    void newPrizesTestByUnderSize() {
        //given
        List<Prize> prizes = generatePrizes(1);

        //when, then
        assertThatThrownBy(() -> new Prizes(prizes))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨품은 2~10개 까지만 등록 가능합니다.");
    }

    @DisplayName("당첨품의 수가 10개 초과인 경우 예외가 발생한다.")
    @Test
    void newPrizesTestByOverSize() {
        //given
        List<Prize> prizes = generatePrizes(11);

        //when, then
        assertThatThrownBy(() -> new Prizes(prizes))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨품은 2~10개 까지만 등록 가능합니다.");
    }

    private List<Prize> generatePrizes(int count) {
        List<Prize> prizes = new ArrayList<>();
        for (int i = 0; i < count; i++) {
             prizes.add(new Prize("당첨품" + i));
        }

        return prizes;
    }
}
