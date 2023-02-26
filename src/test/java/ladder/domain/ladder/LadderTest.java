package ladder.domain.ladder;

import ladder.domain.generator.BooleanGenerator;
import ladder.domain.generator.MockBooleanGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private final int heightOfLadder = 5;
    private final int playerCount = 5;
    private BooleanGenerator valueGenerator;

    @BeforeEach
    void setup() {
        valueGenerator = new MockBooleanGenerator(List.of(true));
    }

    @Test
    @DisplayName("사다리 생성을 테스트")
    void ladderInitiatorTest() {
        Assertions.assertDoesNotThrow(() -> Ladder.create(playerCount, heightOfLadder, valueGenerator));
    }

    @Test
    @DisplayName("사다리 사이즈 getterTest")
    void ladderGetValueTest() {
        Ladder ladder = Ladder.create(playerCount, heightOfLadder, valueGenerator);

        assertThat(ladder.getLadder().size()).isEqualTo(heightOfLadder);
    }


    @Test
    @DisplayName("Bar가 아예 없는 사다리 결과 테스트")
    void resultStraightLadderTest() {
        Ladder ladder = Ladder.create(2, 5, new MockBooleanGenerator(List.of(false)));

        assertThat(ladder.findLadderResult(0)).isEqualTo(0);
        assertThat(ladder.findLadderResult(1)).isEqualTo(1);
    }

    @Test
    @DisplayName("Bar가 있는 복잡한 사다리 결과 테스트")
    void resultCurvedLadderTest() {
        Ladder ladder = Ladder.create(4, 5, new MockBooleanGenerator(List.of(true, true, false)));
        /* 다음과 같은 사다리가 생성된다 가정
         * |-| |-|
         * | |-| |
         * |-| | |
         * |-| |-|
         * | |-| |
         */
        assertThat(ladder.findLadderResult(0)).isEqualTo(3);
        assertThat(ladder.findLadderResult(1)).isEqualTo(0);
        assertThat(ladder.findLadderResult(2)).isEqualTo(1);
        assertThat(ladder.findLadderResult(3)).isEqualTo(2);
    }

}

