package ladder.domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.domain.MockRandomBooleanGenerator;
import ladder.domain.ladder.Ladder;
import ladder.domain.laddergame.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerTest {

    private static final Ladder ladder = Ladder.from(2, 3, new MockRandomBooleanGenerator());
    private static final PlayerName name = new PlayerName("pobi");

    /**
     * 0    1    2
     * true,false
     * true,false
     **/
    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,1", "2,2"})
    @DisplayName("사다리를 타고 예상한 endPosition에 도달하는지 확인한다")
    void traceThePathTest(final int start, final int end) {
        final Position startPosition = new Position(start);
        final Player player = new Player(name, startPosition);

        assertThat(player.traceThePath(ladder))
                .isEqualTo(new Position(end));
    }

}
