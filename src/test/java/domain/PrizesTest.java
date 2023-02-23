package domain;

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
        List<Prize> prizes = List.of(new Prize("꽝"), new Prize("5000"));

        // when + then
        Assertions.assertThatThrownBy(() -> new Prizes(playerCount, prizes))
            .isInstanceOf(InvalidPrizesSizeException.class);
    }

}
