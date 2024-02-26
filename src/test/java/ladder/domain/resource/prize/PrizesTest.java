package ladder.domain.resource.prize;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PrizesTest {

    @DisplayName("당첨품의 수가 2~10이 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 11})
    void newPrizesTestByOutOfSize(int count) {
        //given
        List<Prize> prizes = generatePrizes(count);

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
