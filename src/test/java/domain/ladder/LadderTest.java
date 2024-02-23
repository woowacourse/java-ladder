package domain.ladder;

import static fixture.PlayersFixture.참가자들;
import static org.assertj.core.api.Assertions.assertThat;

import domain.height.Height;
import domain.player.Players;
import org.junit.jupiter.api.Test;
import support.ConnectedLadderRungGenerator;

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
}
