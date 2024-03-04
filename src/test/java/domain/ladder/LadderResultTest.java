package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.player.Player;
import domain.prize.Prize;
import java.util.Map;
import org.junit.jupiter.api.Test;

class LadderResultTest {
    @Test
    void 존재하지_않는_참가자의_결과를_확인할_경우_예외가_발생한다() {
        // given
        Map<Player, Prize> results = Map.of(
                new Player("프린"), new Prize("100"),
                new Player("땡이"), new Prize("꽝")
        );
        LadderResult ladderResult = new LadderResult(results);

        // when & then
        assertThatThrownBy(() -> ladderResult.findPrizeByPlayerName("토미"))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("존재하지 않는 참가자입니다.");
    }

    @Test
    void 존재하는_참가자의_결과를_확인하면_상품을_반환한다() {
        // given
        Map<Player, Prize> results = Map.of(
                new Player("프린"), new Prize("100"),
                new Player("땡이"), new Prize("꽝")
        );
        LadderResult ladderResult = new LadderResult(results);

        // when
        Prize prize = ladderResult.findPrizeByPlayerName("프린");

        // then
        assertThat(prize.getName()).isEqualTo("100");
    }
}
