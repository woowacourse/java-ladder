package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import ladder.domain.linegenerator.LinePatternGenerator;
import org.junit.jupiter.api.BeforeEach;

class LadderGameTest {
    private List<PlayerName> playerNames;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        List<PlayerName> playerNames = new ArrayList<>();
        playerNames.add(new PlayerName("hogee"));
        playerNames.add(new PlayerName("jazz"));
        playerNames.add(new PlayerName("pola"));

        ladder = Ladder.makeLadder(new Height(4), 3, new LinePatternGenerator(new AlwaysTrueSupplier()));
    }

    static class AlwaysTrueSupplier implements BooleanSupplier {
        @Override
        public boolean getAsBoolean() {
            return true;
        }
    }
}
