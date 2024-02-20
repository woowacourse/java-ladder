package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리는 참여자 수와 높이를 가진다.")
    void testConstruct() {
        int playerCount = 4;
        int height = 5;
        Ladder ladder = new Ladder(playerCount, height);

        assertThat(ladder).extracting("playerCount")
                .isEqualTo(4);
        assertThat(ladder).extracting("height")
                .isEqualTo(5);
    }
}
