package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import ladder.domain.linegenerator.LinePatternGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {
    private List<PlayerName> playerNames;
    private Ladder ladder;

    @Test
    @DisplayName("게임 결과를 확인한다")
    void playGameTest() {
        List<PlayerName> playerNames = new ArrayList<>();
        playerNames.add(new PlayerName("hogee"));
        playerNames.add(new PlayerName("jazz"));
        playerNames.add(new PlayerName("pola"));

        ladder = Ladder.makeLadder(new Height(3), 3, new LinePatternGenerator(new AlwaysTrueSupplier()));

        LadderGame ladderGame = new LadderGame(playerNames, ladder);
        List<String> result = ladderGame.playGame();
        Assertions.assertThat(result).containsExactly("jazz", "hogee", "pola");
    }

    static class AlwaysTrueSupplier implements BooleanSupplier {
        @Override
        public boolean getAsBoolean() {
            return true;
        }
    }
}
