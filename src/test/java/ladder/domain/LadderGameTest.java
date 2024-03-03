package ladder.domain;

import java.util.List;
import java.util.function.BooleanSupplier;
import ladder.domain.linegenerator.LineGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {
    private Ladder ladder;

    @Test
    @DisplayName("게임 결과를 확인한다")
    void playGameTest() {
        List<PlayerName> playerNames = List.of(
                new PlayerName("hogee"),
                new PlayerName("jazz"),
                new PlayerName("pola")
        );

        ladder = Ladder.makeLadder(new Height(3), 3, new LineGenerator(new AlwaysTrueSupplier()));

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
