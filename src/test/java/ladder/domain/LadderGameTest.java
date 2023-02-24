package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    /*
    a   b   c
    |---|   |
    |   |---|
    b   c   a
   */
    @Test
    @DisplayName("사람 이름을 입력하면 해당 item를 반환한다")
    void shouldReturnResultItemWhenInputName() {
        Players players = Players.generate(List.of("a", "b", "c"));
        List<Boolean> determinedBars = new ArrayList<>(List.of(true, false, true));
        Ladder ladder = Ladder.generate(2, 2, new DeterminedBooleanGenerator(determinedBars));
        Items items = Items.generate(List.of("1000", "2000", "0"), players.getSize());
        LadderGame ladderGame = new LadderGame(players, ladder, items);

        Player player = players.findBy("a");
        GameResult gameResult = ladderGame.play();

        assertThat(gameResult.findResult(player)).containsEntry(player, items.findBy(2));
    }
}
