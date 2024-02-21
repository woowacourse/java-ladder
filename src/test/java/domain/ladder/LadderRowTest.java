package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LadderRowTest {
    @Test
    void 플레이어_수만큼_가로대를_생성한다() {
        // given
        final int playerSize = 5;

        // when
        LadderRow ladderRow = LadderRow.create(playerSize, () -> true);

        // then
        assertThat(ladderRow.getRungs()).hasSize(playerSize);
    }
}
