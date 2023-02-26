package ladder.domain.ladder;

import ladder.domain.generator.BooleanGenerator;
import ladder.domain.generator.MockBooleanGenerator;
import ladder.domain.generator.RandomBooleanGenerator;
import org.junit.jupiter.api.*;

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
    @DisplayName("플레이어 수 -1 크기의 사다리가 생성되는지 확인한다.")
    void generateLineSizeTest() {
        assertThat(Ladder.create(playerCount, heightOfLadder, new RandomBooleanGenerator()).getLadder().get(0).getLine().size())
                .isEqualTo(playerCount - 1);
    }

    @RepeatedTest(100)
    @DisplayName("생성된 Line의 가로가 겹치지 않는지 확인한다.")
    void generateLineTest() {
        List<Bar> bars = Ladder.create(100, 1,new RandomBooleanGenerator())
                .getLadder().get(0).getLine();

        for (int idx = 0; idx < bars.size() - 1; idx++) {
            Bar currentBar = bars.get(idx);
            Bar nextBar = bars.get(idx + 1);

            assertThat(!currentBar.getValue() || !nextBar.getValue())
                    .isTrue();
        }
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

