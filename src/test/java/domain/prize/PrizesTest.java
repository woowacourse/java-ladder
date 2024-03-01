package domain.prize;

import static fixture.PlayersFixture.참가자들;
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
        assertThatThrownBy(() -> Prizes.of(prizeNames, players))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 참가자_수와_상품_수가_같으면_예외가_발생하지_않는다() {
        // given
        List<String> prizeNames = List.of("1000", "꽝", "500");
        Players players = 참가자들(3);

        // when & then
        assertThatCode(() -> Prizes.of(prizeNames, players))
                .doesNotThrowAnyException();
    }
}
