package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import domain.booleanGenerator.BooleanGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;
import support.TrueGenerator;

public class LadderRowTest {
    private final BooleanGenerator trueGenerator = new TrueGenerator();

    @Test
    void 플레이어_수만큼_가로대를_생성한다() {
        // given
        final int playerSize = 5;

        // when
        LadderRow ladderRow = new LadderRow(trueGenerator, playerSize);

        // then
        assertThat(ladderRow.getLadderPoints()).hasSize(playerSize);
    }

    @Test
    void 이전_가로대가_연결되어_있으면_가로대를_연속해서_놓을_수_없다() {
        // given
        final int playerSize = 4;

        // when
        LadderRow ladderRow = new LadderRow(trueGenerator, playerSize);

        // then
        List<DirectionalPoint> ladderPoint = ladderRow.getLadderPoints();
        assertAll(
                () -> assertThat(ladderPoint.get(0)).isEqualTo(DirectionalPoint.RIGHT),
                () -> assertThat(ladderPoint.get(1)).isEqualTo(DirectionalPoint.LEFT),
                () -> assertThat(ladderPoint.get(2)).isEqualTo(DirectionalPoint.RIGHT),
                () -> assertThat(ladderPoint.get(3)).isEqualTo(DirectionalPoint.LEFT)
        );
    }
}
