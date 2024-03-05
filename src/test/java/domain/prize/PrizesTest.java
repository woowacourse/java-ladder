package domain.prize;

import static fixture.PlayersFixture.참가자들;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.player.Players;
import java.util.List;
import org.junit.jupiter.api.Test;

class PrizesTest {
    @Test
    void 참가자_수와_상품_수가_다르면_예외가_발생한다() {
        // given
        List<String> prizeNames = List.of("1000", "꽝", "123", "500");
        Players players = 참가자들(3);

        // when & then
        assertThatThrownBy(() -> Prizes.of(prizeNames, players.count()))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 참가자_수와_상품_수가_같으면_예외가_발생하지_않는다() {
        // given
        List<String> prizeNames = List.of("1000", "꽝", "500");
        Players players = 참가자들(3);

        // when & then
        assertThatCode(() -> Prizes.of(prizeNames, players.count()))
                .doesNotThrowAnyException();
    }

    @Test
    void 상품명_중_가장_긴_상품명의_길이를_반환한다() {
        // given
        String maxLengthName = "10000";
        Prizes prizes = Prizes.of(List.of("꽝", "500", maxLengthName), 3);

        // when
        int result = prizes.findMaxPrizeNameLength();

        // then
        assertThat(result).isEqualTo(maxLengthName.length());
    }

    @Test
    void 범위를_벗어난_인덱스로_상품을_찾으면_예외가_발생한다() {
        // given
        List<String> prizeNames = List.of("1000", "꽝", "500");
        Prizes prizes = Prizes.of(prizeNames, 3);

        // when & then
        assertThatThrownBy(() -> prizes.findPrizeByIndex(3))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 인덱스로_상품을_찾는다() {
        // given
        String targetPrizeName = "꽝";
        Prizes prizes = Prizes.of(List.of("1000", targetPrizeName, "500"), 3);

        // when
        Prize prize = prizes.findPrizeByIndex(1);

        // then
        assertThat(prize.getName()).isEqualTo(targetPrizeName);
    }
}
