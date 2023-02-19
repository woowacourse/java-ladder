package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.NonExistFootholdGenerator;

class GameTest {

    @Test
    @DisplayName("사다리 게임의 결과를 계산한다.)")
    void calculate_ladder_game_result() {
        // given
        List<String> playerNames = List.of("pobi", "crong", "honux");
        Players players = new Players(playerNames);
        Line line = new Line(playerNames.size(), new NonExistFootholdGenerator());
        Lines lines = new Lines(List.of(line, line, line, line));
        Ladder ladder = new Ladder(lines, new Height(4));
        LadderResults ladderResults = new LadderResults(List.of("1", "2", "3"), playerNames.size());

        Game game = new Game(ladder, players, ladderResults);

        // when
        game.calculatePlayerResults();

        // then
        assertThat(players.getPlayers().get(1).getResult()).isEqualTo(
                ladderResults.getLadderResultOfIndex(1));
    }

}
