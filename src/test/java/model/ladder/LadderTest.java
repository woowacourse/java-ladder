package model.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import model.line.LineGenerator;
import model.line.RandomLineGenerator;
import model.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("사다리는 사다리 높이만큼의 라인을 가짐")
    @Test
    void testSizeOfLadderLines() {
        Players players = Players.of(List.of("pobi", "lala", "jojo", "gamja"));
        LadderHeight ladderHeight = new LadderHeight(5);
        LineGenerator lineGenerator = new RandomLineGenerator();
        Ladder ladder = Ladder.of(ladderHeight, players, lineGenerator);
        assertThat(ladder.getLines().size())
                .isEqualTo(5);
    }
}
