package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private final int heightOfLadder = 5;
    private final int playerCount = 5;

    @Test
    @DisplayName("사다리 생성을 테스트")
    void ladderInitiatorTest() {
        Assertions.assertDoesNotThrow(() -> Ladder.create(playerCount, heightOfLadder));
    }

    @Test
    @DisplayName("사다리 사이즈 getterTest")
    void ladderGetValueTest() {
        Ladder ladder = Ladder.create(playerCount, heightOfLadder);

        assertThat(ladder.getLadder().size()).isEqualTo(heightOfLadder);
    }
}

