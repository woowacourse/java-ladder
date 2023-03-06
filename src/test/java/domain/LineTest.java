package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.BooleanGenerator;
import util.RandomBooleanGenerator;
import util.TrueGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("입력값으로 LineStep의 개수(플레이어수-1)가 주어졌을 때 LineStep이 해당 개수만큼 생성")
    void makeLine() {
        int numberOfLineStep = 3;

        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
        Line line = Line.makeDefaultLine(numberOfLineStep, booleanGenerator);

        assertThat(line.getLine().size()).isEqualTo(numberOfLineStep);
    }

    @Test
    @DisplayName("첫째 다리스텝이 존재할 경우 둘째 스텝은 생성되지 않음")
    void ifFirstStepExistSecondStepIsNotExist() {
        int numberOfHorizontalSteps = 2;
        BooleanGenerator booleanGenerator = new TrueGenerator();

        Line line = Line.makeDefaultLine(numberOfHorizontalSteps, booleanGenerator);
        line.generateRandomLine();

        org.junit.jupiter.api.Assertions.assertAll(
                () -> assertThat(line.getLine().get(0)).isEqualTo(LineStep.EXIST),
                () -> assertThat(line.getLine().get(1)).isEqualTo(LineStep.NON_EXIST)
        );
    }

    @Test
    @DisplayName("충분히 많은 RandomLineStep을 생성했을 때도 라인이 겹치는 경우는 존재하지 않음")
    void NoneDuplicationOfLineStepStatus() {
        int numberOfLineStep = 1000;
        Line line = Line.makeDefaultLine(numberOfLineStep, new RandomBooleanGenerator());

        line.generateRandomLine();

        for (int i = 0; i < numberOfLineStep - 1; i++) {
            int rightLineStepsIndex = i + 1;
            if (line.getLine().get(i) == LineStep.EXIST) {
                Assertions.assertThat(line.getLine().get(rightLineStepsIndex)).isEqualTo(LineStep.NON_EXIST);
            }
        }
    }

    @Test
    @DisplayName("라인의 첫 번째에 위치한 플레이어는 오른쪽으로만 이동할 수 있다")
    void movePlayerToRightDirection() {
        Player player = new Player("roy", 0);
        int numberOfSteps = 3;
        BooleanGenerator booleanGenerator = new TrueGenerator();
        Line line = Line.makeDefaultLine(numberOfSteps, booleanGenerator);
        line.generateRandomLine();

        line.movePlayerInLine(player);

        assertThat(player.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("라인의 마지막에 위치한 플레이어는 왼쪽으로만 이동할 수 있다.")
    void movePlayerToLeftDirection() {
        Player player = new Player("roy", 3);
        int numberOfSteps = 3;
        BooleanGenerator booleanGenerator = new TrueGenerator();
        Line line = Line.makeDefaultLine(numberOfSteps, booleanGenerator);
        line.generateRandomLine();

        line.movePlayerInLine(player);

        assertThat(player.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("플레이의의 양쪽 다리가 모두 끊어진 경우 플레이어는 움직이지 않는다.")
    void stayPlayerWhenBothSideOfStepsAreNonExist() {
        Player player = new Player("roy", 1);
        int numberOfSteps = 2;
        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
        Line line = Line.makeDefaultLine(numberOfSteps, booleanGenerator);

        line.movePlayerInLine(player);

        assertThat(player.getPosition()).isEqualTo(1);
    }
}
