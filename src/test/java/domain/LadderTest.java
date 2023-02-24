package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.BooleanGenerator;
import util.RandomBooleanGenerator;
import util.TrueGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderTest {

    @Test
    @DisplayName("입력값으로 플레이어 숫자와 높이가 주어졌을 때 가로와 높이가 정확한 사다리 생성")
    void makeLadderWithCorrectWidthAndHeight() {
        int numberOfPlayers = 4;
        int height = new Height(5).getHeight();
        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();

        Ladder ladder = Ladder.makeDefaultLadder(numberOfPlayers, height, booleanGenerator);
        Line firstLine = ladder.getLines().get(0);

        assertAll(
                () -> assertThat(ladder.getLines().size()).isEqualTo(height),
                () -> assertThat(firstLine.getLine().size()).isEqualTo(numberOfPlayers - 1)
        );
    }

    @Test
    @DisplayName("default 사다리는 생성된다면 해당 사다리의 라인은 모두 연결되지 않음")
    void makeDefaultLadderWithNothingOfLineSteps() {
        int numberOfPlayers = 4;
        int height = new Height(5).getHeight();
        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();

        Ladder defaultLadder = Ladder.makeDefaultLadder(numberOfPlayers, height, booleanGenerator);

        for (Line line : defaultLadder.getLines()) {
            for (LineStep lineStep : line.getLine()) {
                assertThat(lineStep).isEqualTo(LineStep.NON_EXIST);
            }
        }
    }

    @Test
    @DisplayName("default 사다리를 이용하여 random 사다리를 생성하면 사다리 라인은 일부 연결됨")
    void makeRandomLadderUsingDefaultLadder() {
        int numberOfPlayers = 4;
        int height = new Height(5).getHeight();
        BooleanGenerator booleanGenerator = new TrueGenerator();
        Ladder randomLadder = Ladder.makeDefaultLadder(numberOfPlayers, height, booleanGenerator);

        randomLadder.generateRandomLadder();

        for (Line line : randomLadder.getLines()) {
            assertThat(line.getLine()).containsAnyOf(LineStep.EXIST);
        }
    }

}
