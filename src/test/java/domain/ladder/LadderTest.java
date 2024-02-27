package domain.ladder;

import static fixture.PlayersFixture.참가자들;
import static fixture.PrizesFixture.상품들;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.height.Height;
import domain.player.Players;
import domain.prize.Prizes;
import java.util.List;
import org.junit.jupiter.api.Test;
import support.ConnectedLadderRungGenerator;
import support.FixedLadderRungGenerator;

public class LadderTest {
    @Test
    void 주어진_높이에_맞게_사다리를_생성한다() {
        // given
        Height height = new Height(5);

        // when
        Ladder ladder = Ladder.create(height, 참가자들(3), 상품들(3), new ConnectedLadderRungGenerator());

        // then
        assertThat(ladder.getRows()).hasSize(height.getValue());
    }

    @Test
    void 참가자_수와_상품_수가_일치하지_않으면_예외가_발생한다() {
        // given
        Players players = 참가자들(3);
        Prizes prizes = 상품들(4);

        // when & then
        assertThatThrownBy(() -> Ladder.create(new Height(1), players, prizes, new ConnectedLadderRungGenerator()))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 참가자_수와_상품_수가_일치하면_예외가_발생하지_않는다() {
        // given
        Players players = 참가자들(3);
        Prizes prizes = 상품들(3);

        // when & then
        assertThatThrownBy(() -> Ladder.create(new Height(1), players, prizes, new ConnectedLadderRungGenerator()))
                .doesNotThrowAnyException();
    }

    @Test
    void 사다리를_탄_후_결과를_반환한다() {
        /*
        프린  땡이  포비  토미  네오
        |-----|     |-----|     |
        |     |-----|     |     |
        |-----|     |     |-----|
        */

        // given
        Height height = new Height(3);
        Players players = 참가자들("프린", "땡이", "포비", "토미", "네오");
        Prizes prizes = 상품들("꽝", "꽝", "꽝", "꽝", "10000");
        List<LadderRung> ladderRungs = List.of(
                LadderRung.CONNECTED, LadderRung.DISCONNECTED, LadderRung.CONNECTED, LadderRung.DISCONNECTED,
                LadderRung.DISCONNECTED, LadderRung.CONNECTED, LadderRung.DISCONNECTED, LadderRung.DISCONNECTED,
                LadderRung.CONNECTED, LadderRung.DISCONNECTED, LadderRung.DISCONNECTED, LadderRung.CONNECTED
        );

        // when
        Ladder ladder = Ladder.create(height, players, prizes, new FixedLadderRungGenerator(ladderRungs));
        List<String> resultNames = ladder.climb();

        // then
        assertThat(resultNames).containsExactly("토미", "땡이", "프린", "네오", "포비");
    }
}
