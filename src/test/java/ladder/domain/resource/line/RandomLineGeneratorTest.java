package ladder.domain.resource.line;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.domain.resource.direction.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomLineGeneratorTest {

    LineGenerator lineGenerator = new RandomLineGenerator();

    @DisplayName("빈 라인을 생성한다.")
    @Test
    void generateLine() {
        //given, when
        Line line = lineGenerator.generateLine();

        //then
        assertThat(line.getSize()).isEqualTo(0);
    }


    @DisplayName("라인에 정해진 수 만큼 방향을 추가한다.")
    @Test
    void insertDirectionIntoLine() {
        //given
        int count = 5;
        Line line = lineGenerator.generateLine();

        //when
        lineGenerator.insertDirectionIntoLine(line, count);

        //then
        assertThat(line.getSize()).isEqualTo(count);
    }

    @DisplayName("라인의 첫번째 값에는 '오른쪽' 또는 '중립'만 올 수 있다.")
    @Test
    void insertDirectionIntoLine_FirstDirection() {
        //given
        int firstIndex = 0;
        Line line = lineGenerator.generateLine();

        //when
        lineGenerator.insertDirectionIntoLine(line, 1);
        Direction firstDirection = line.getDirectionByIndex(firstIndex);

        //when, then
        assertThat(firstDirection).isIn(Direction.RIGHT, Direction.NEUTRAL);
    }

    @DisplayName("라인의 두번째 값 부터는 이전의 값이 '오른쪽'이라면 다음 값은 무조건 '왼쪽'이 와야 한다.")
    @Test
    void insertDirectionIntoLine_afterRightDirection_expectedLeft() {
        //given
        int firstIndex = 0;
        int secondIndex = 1;
        Line line = lineGenerator.generateLine();
        line.addDirection(Direction.RIGHT);

        //when
        lineGenerator.insertDirectionIntoLine(line, 2);
        Direction firstDirection = line.getDirectionByIndex(firstIndex);
        Direction secondDirection = line.getDirectionByIndex(secondIndex);

        //then
        assertThat(firstDirection).isEqualTo(Direction.RIGHT);
        assertThat(secondDirection).isEqualTo(Direction.LEFT);
    }

    @DisplayName("라인에서 두번째 값 부터는 이전 값이 '왼쪽'이라면 다음 값은 '오른쪽' 또는 '중립'이 되어야 한다.")
    @Test
    void insertDirectionIntoLine_afterLeftDirection_expectedRightOrNeutral() {//수정 필요
        //given
        int firstIndex = 0;
        int secondIndex = 1;
        Line line = lineGenerator.generateLine();
        line.addDirection(Direction.LEFT);

        //when
        lineGenerator.insertDirectionIntoLine(line, 2);
        Direction firstDirection = line.getDirectionByIndex(firstIndex);
        Direction secondDirection = line.getDirectionByIndex(secondIndex);

        //when, then
        assertThat(firstDirection).isEqualTo(Direction.LEFT);
        assertThat(secondDirection).isIn(Direction.RIGHT, Direction.NEUTRAL);
    }

    @DisplayName("라인에서 두번째 값 부터는 이전 값이 '중립'이라면 다음 값은 '오른쪽' 또는 '중립'이 되어야 한다.")
    @Test
    void insertDirectionIntoLine_afterNeutralDirection_expectedRightOrNeutral() {
        //given
        int firstIndex = 0;
        int secondIndex = 1;
        Line line = lineGenerator.generateLine();
        line.addDirection(Direction.NEUTRAL);

        //when
        lineGenerator.insertDirectionIntoLine(line, 2);
        Direction firstDirection = line.getDirectionByIndex(firstIndex);
        Direction secondDirection = line.getDirectionByIndex(secondIndex);

        //then
        assertThat(firstDirection).isEqualTo(Direction.NEUTRAL);
        assertThat(secondDirection).isIn(Direction.RIGHT, Direction.NEUTRAL);
    }

    @DisplayName("라인에서 마지막 값의 직전 값이 '오른쪽'이라면 마지막 값은 '왼쪽'이 되어야 한다.")
    @Test
    void insertDirectionIntoLine_afterLastRightDirection_expectedLeft() {
        //given
        int firstIndex = 0;
        int secondIndex = 1;
        Line line = lineGenerator.generateLine();
        line.addDirection(Direction.RIGHT);

        //when
        lineGenerator.insertDirectionIntoLine(line, 1);
        Direction firstDirection = line.getDirectionByIndex(firstIndex);
        Direction lastDirection = line.getDirectionByIndex(secondIndex);

        //then
        assertThat(firstDirection).isEqualTo(Direction.RIGHT);
        assertThat(lastDirection).isEqualTo(Direction.LEFT);
    }

    @DisplayName("라인에서 마지막 값의 직전 값이 '왼쪽'이라면 마지막 값은 '중립'이 되어야 한다.")
    @Test
    void insertDirectionIntoLine_afterLastLeftDirection_expectedNeutral() {
        //given
        int firstIndex = 0;
        int secondIndex = 1;
        Line line = lineGenerator.generateLine();
        line.addDirection(Direction.LEFT);

        //when
        lineGenerator.insertDirectionIntoLine(line, 1);
        Direction firstDirection = line.getDirectionByIndex(firstIndex);
        Direction lastDirection = line.getDirectionByIndex(secondIndex);
        //then
        assertThat(firstDirection).isEqualTo(Direction.LEFT);
        assertThat(lastDirection).isEqualTo(Direction.NEUTRAL);
    }

    @DisplayName("라인에서 마지막 값의 직전 값이 '중립'이라면 마지막 값은 '중립'이 되어야 한다.")
    @Test
    void insertDirectionIntoLine_afterLastNeutralDirection_expectedNeutral() {
        //given
        int firstIndex = 0;
        int secondIndex = 1;
        Line line = lineGenerator.generateLine();
        line.addDirection(Direction.NEUTRAL);

        //when
        lineGenerator.insertDirectionIntoLine(line, 1);
        Direction firstDirection = line.getDirectionByIndex(firstIndex);
        Direction lastDirection = line.getDirectionByIndex(secondIndex);
        //then
        assertThat(firstDirection).isEqualTo(Direction.NEUTRAL);
        assertThat(lastDirection).isEqualTo(Direction.NEUTRAL);
    }
}
