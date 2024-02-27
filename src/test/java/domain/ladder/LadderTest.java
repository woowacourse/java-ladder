package domain.ladder;

import static fixture.PlayersFixture.참가자들;
import static org.assertj.core.api.Assertions.assertThat;

import domain.height.Height;
import domain.player.Players;
import java.util.List;
import org.junit.jupiter.api.Test;
import support.ConnectedLadderRungGenerator;
import support.FixedLadderRungGenerator;

public class LadderTest {
    private final LadderRungGenerator ladderRungGenerator = new ConnectedLadderRungGenerator();

    @Test
    void 주어진_높이에_맞게_사다리를_생성한다() {
        // given
        Height height = new Height(5);
        Players players = 참가자들(3);

        // when
        Ladder ladder = Ladder.create(height, players, ladderRungGenerator);

        // then
        assertThat(ladder.getRows()).hasSize(height.getValue());
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
        List<LadderRung> ladderRungs = List.of(
                LadderRung.CONNECTED, LadderRung.DISCONNECTED, LadderRung.CONNECTED, LadderRung.DISCONNECTED,
                LadderRung.DISCONNECTED, LadderRung.CONNECTED, LadderRung.DISCONNECTED, LadderRung.DISCONNECTED,
                LadderRung.CONNECTED, LadderRung.DISCONNECTED, LadderRung.DISCONNECTED, LadderRung.CONNECTED
        );

        // when
        Ladder ladder = Ladder.create(height, players, new FixedLadderRungGenerator(ladderRungs));
        List<String> resultNames = ladder.climb(players);

        // then
        assertThat(resultNames).containsExactly("토미", "땡이", "프린", "네오", "포비");
    }
}
