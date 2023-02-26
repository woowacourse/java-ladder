package domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import exception.InvalidPrizesSizeException;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PrizesTest {

    @Test
    void 상품들의_개수가_플레이어의_수와_다르면_에러가_발생한다() {
        //given
        int playerCount = 3;
        List<String> prizes = List.of("꽝", "5000");

        // when + then
        Assertions.assertThatThrownBy(() -> Prizes.generatePrizes(playerCount, prizes))
            .isInstanceOf(InvalidPrizesSizeException.class);
    }

    @Test
    void getPrizeNames_하면_상품들의_이름_리스트를_반환한다() {
        //given
        int playerCount = 3;
        List<String> prizeName = List.of("꽝", "5000", "꽝");
        Prizes prizes = Prizes.generatePrizes(playerCount, prizeName);

        //when
        List<String> result = prizes.getPrizeName();

        //then
        assertTrue(result.containsAll(prizeName));
    }
}
