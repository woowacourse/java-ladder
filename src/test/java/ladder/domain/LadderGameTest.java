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
        players = new Players(playerNames);

        List<Line> lines = new ArrayList<>();
        lines.add(new Line(List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE, Stick.EXISTENCE)));
        ladder = Ladder.makeLadder(new Height(3), 3, new LinePatternGenerator(new AlwaysTrueSupplier()));
    }

    @Test
    @DisplayName("한 라인에 대한 게임을 진행한다")
    void playOneLine() {
        LadderGame ladderGame = new LadderGame(players, ladder);
        ladderGame.playOneLine(0);

        Assertions.assertThat(ladderGame.getPlayerResult()).containsExactly("jazz", "hogee");
    }

    class AlwaysTrueSupplier implements BooleanSupplier {
        @Override
        public boolean getAsBoolean() {
            return true;
        }
    }
}
