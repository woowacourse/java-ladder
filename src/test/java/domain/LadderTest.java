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
    @DisplayName("default 사다리를 이용하여 random 사다리를 생성함")
    void makeRandomLadderUsingDefaultLadder() {
        int numberOfPlayers = 4;
        int height = new Height(5).getHeight();
        BooleanGenerator booleanGenerator = new TrueGenerator();
        Ladder ladder = Ladder.makeDefaultLadder(numberOfPlayers, height, booleanGenerator);

        ladder.generateRandomLadder();

        for (Line line : ladder.getLines()) {
            assertThat(line.getLine()).containsAnyOf(LineStep.EXIST);
        }
    }

    @Test
    @DisplayName("player 그룹을 입력하면 사다리 타기가 진행되고 개별 Line에서 player의 위치(position)가 변경됨")
    void movePlayersInLines() {
        Ladder ladder = Ladder.makeDefaultLadder(4, 5, new TrueGenerator());
        ladder.generateRandomLadder();
        Players players = Players.from(new String[]{"roy", "hoy", "joy", "poy"});

        ladder.movePlayers(players);
        Player roy = players.getPlayers().get(0);
        Player hoy = players.getPlayers().get(1);
        Player joy = players.getPlayers().get(2);
        Player coy = players.getPlayers().get(3);

        assertThat(roy.getPosition()).isEqualTo(1);
        assertThat(hoy.getPosition()).isEqualTo(0);
        assertThat(joy.getPosition()).isEqualTo(3);
        assertThat(coy.getPosition()).isEqualTo(2);
    }
}
