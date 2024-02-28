package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import ladder.domain.linegenerator.LinePatternGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {
    private Players players;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        List<PlayerName> playerNames = new ArrayList<>();
        playerNames.add(new PlayerName("hogee"));
        playerNames.add(new PlayerName("jazz"));
        playerNames.add(new PlayerName("pola"));
        players = new Players(playerNames);

        ladder = Ladder.makeLadder(new Height(4), 3, new LinePatternGenerator(new AlwaysTrueSupplier()));
    }

    @Test
    @DisplayName("한 라인에 대한 게임을 진행한다")
    void playOneLine() {
        LadderGame ladderGame = new LadderGame(players, ladder);
        ladderGame.playOneLine(0);

        Assertions.assertThat(ladderGame.getPlayerResult()).containsExactly("jazz", "hogee", "pola");
    }

    @Test
    @DisplayName("전체 라인에 대한 게임을 진행한다.")
    void playAllLineGame() {
        LadderGame ladderGame = new LadderGame(players, ladder);
        ladderGame.playAllGame();
        Assertions.assertThat(ladderGame.getPlayerResult()).containsExactly("hogee", "jazz", "pola");
    }

    class AlwaysTrueSupplier implements BooleanSupplier {
        @Override
        public boolean getAsBoolean() {
            return true;
        }
    }
}
