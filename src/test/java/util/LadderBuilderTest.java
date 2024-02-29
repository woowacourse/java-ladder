package util;

import domain.CustomGenerator;
import domain.Height;
import domain.Ladder;
import domain.Line;
import domain.Players;
import domain.Winnings;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderBuilderTest {
    @DisplayName("Line 에서 출력 형태를 반환한다.")
    @Test
    void fromLineTest() {
        Line line = new Line(List.of(4, 5));
        Assertions.assertThat(LadderBuilder.fromLine(line))
                .isEqualTo("     |-----|");
    }

    @DisplayName("Ladder 에서 출력 형태를 반환한다.")
    @Test
    void fromLadderTest() {
        Ladder ladder = new Ladder(new Height(2));
        CustomGenerator customGenerator = new CustomGenerator(List.of(false, true));
        ladder.init(2, customGenerator);
        Assertions.assertThat(LadderBuilder.fromLadder(ladder))
                .isEqualTo(List.of("     |-----|", "     |-----|"));
    }

    @DisplayName("Players 에서 출력 형태를 반환한다.")
    @Test
    void nameBuilderTest() {
        Players players = new Players(List.of("1", "2"));
        Assertions.assertThat(LadderBuilder.nameBuilder(players))
                .isEqualTo("     1     2");
    }

    @DisplayName("Winnings 에서 출력 형태를 반환한다.")
    @Test
    void winningBuilderTest() {
        Winnings winnings = new Winnings(List.of("꽝", "당첨"));
        Assertions.assertThat(LadderBuilder.winningBuilder(winnings))
                .isEqualTo("     꽝    당첨");
    }
}
