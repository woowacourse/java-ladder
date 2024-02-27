package ladder.domain.line;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.direction.Direction;
import ladder.domain.direction.RandomDirectionGenerator;
import ladder.domain.direction.NeutralDirectionGenerator;
import ladder.domain.direction.RightDirectionGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineGeneratorTest {

    @DisplayName("정해진 수만큼 라인의 너비를 가지는 라인을 생성한다.")
    @Test
    void lineGenerateTest() {
        //given
        int width = 5;
        LineGenerator lineGenerator = new LineGenerator(new RandomDirectionGenerator());
        Line line = lineGenerator.generate(width);
        List<Direction> directionsInfo = line.getDirectionsInfo();

        //when, then
        assertThat(directionsInfo).hasSize(width);
    }

    @DisplayName("라인의 첫번째 값에는 '오른쪽' 또는 '중립'만 올 수 있다.")
    @Test
    void lineGenerateTestByFirstValue() {
        //given
        int width = 1;
        int firstIndex = 0;
        LineGenerator lineGenerator = new LineGenerator(new RandomDirectionGenerator());
        Line line = lineGenerator.generate(width);
        List<Direction> directionsInfo = line.getDirectionsInfo();

        //when
        Direction direction = directionsInfo.get(firstIndex);

        //then
        assertThat(direction).isNotEqualTo(Direction.LEFT);
    }

    @DisplayName("라인의 두번째 값 부터는 이전의 값이 '오른쪽'이라면 다음 값은 무조건 '왼쪽'이 와야 한다.")
    @Test
    void lineGenerateTestByRightBeforeLeft() {
        //given
        int width = 2;
        int firstIndex = 0;
        int secondIndex = 1;
        LineGenerator lineGenerator = new LineGenerator(new RightDirectionGenerator());
        Line line = lineGenerator.generate(width);
        List<Direction> directionsInfo = line.getDirectionsInfo();

        //when
        Direction firstLineDirection = directionsInfo.get(firstIndex);
        Direction secondLineDirection = directionsInfo.get(secondIndex);

        //then
        assertThat(firstLineDirection).isEqualTo(Direction.RIGHT);
        assertThat(secondLineDirection).isEqualTo(Direction.LEFT);
    }

    @DisplayName("라인에서 두번째 값 부터는 이전 값이 '왼쪽'이라면 다음 값은 '오른쪽' 또는 '중립'이 되어야 한다.")
    @Test
    void lineGenerateTestByRNBeforeLeft() {
        //given
        int width = 3;
        int secondIndex = 1;
        int thirdIndex = 2;
        LineGenerator lineGenerator = new LineGenerator(new RightDirectionGenerator());
        Line line = lineGenerator.generate(width);
        List<Direction> directionsInfo = line.getDirectionsInfo();

        //when
        Direction secondLineDirection = directionsInfo.get(secondIndex);
        Direction thirdLineDirection = directionsInfo.get(thirdIndex);
        boolean isDirectionRN = (thirdLineDirection == Direction.RIGHT
                || thirdLineDirection == Direction.NEUTRAL);

        //then
        assertThat(secondLineDirection).isEqualTo(Direction.LEFT);
        assertThat(isDirectionRN).isTrue();
    }

    @DisplayName("라인에서 두번째 값 부터는 이전 값이 '중립'이라면 다음 값은 '오른쪽' 또는 '중립'이 되어야 한다.")
    @Test
    void lineGenerateTestByRNBeforeNeutral() {
        //given
        int width = 2;
        int firstIndex = 0;
        int secondIndex = 1;
        LineGenerator lineGenerator = new LineGenerator(new NeutralDirectionGenerator());
        Line line = lineGenerator.generate(width);
        List<Direction> directionsInfo = line.getDirectionsInfo();

        //when
        Direction firstLineDirection = directionsInfo.get(firstIndex);
        Direction secondLineDirection = directionsInfo.get(secondIndex);
        boolean isDirectionRN = (secondLineDirection == Direction.RIGHT
                || secondLineDirection == Direction.NEUTRAL);

        //then
        assertThat(firstLineDirection).isEqualTo(Direction.NEUTRAL);
        assertThat(isDirectionRN).isTrue();
    }

    @DisplayName("라인에서 마지막 값의 직전 값이 '오른쪽'이라면 마지막 값은 '왼쪽'이 되어야 한다.")
    @Test
    void lineGenerateTestByLastBeforeRight() {
        //given
        int width = 2;
        int firstIndex = 0;
        int secondIndex = 1;
        LineGenerator lineGenerator = new LineGenerator(new RightDirectionGenerator());
        Line line = lineGenerator.generate(width);
        List<Direction> directionsInfo = line.getDirectionsInfo();

        //when
        Direction firstLineDirection = directionsInfo.get(firstIndex);
        Direction secondLineDirection = directionsInfo.get(secondIndex);

        //then
        assertThat(firstLineDirection).isEqualTo(Direction.RIGHT);
        assertThat(secondLineDirection).isEqualTo(Direction.LEFT);
    }

    @DisplayName("라인에서 마지막 값의 직전 값이 '왼쪽'이라면 마지막 값은 '중립'이 되어야 한다.")
    @Test
    void lineGenerateTestByLastBeforeLeft() {
        //given
        int width = 3;
        int firstIndex = 0;
        int secondIndex = 1;
        int thirdIndex = 2;
        LineGenerator lineGenerator = new LineGenerator(new RightDirectionGenerator());
        Line line = lineGenerator.generate(width);
        List<Direction> directionsInfo = line.getDirectionsInfo();

        //when
        Direction firstLineDirection = directionsInfo.get(firstIndex);
        Direction secondLineDirection = directionsInfo.get(secondIndex);
        Direction thirdLineDirection = directionsInfo.get(thirdIndex);

        //then
        assertThat(firstLineDirection).isEqualTo(Direction.RIGHT);
        assertThat(secondLineDirection).isEqualTo(Direction.LEFT);
        assertThat(thirdLineDirection).isEqualTo(Direction.NEUTRAL);
    }

    @DisplayName("라인에서 마지막 값의 직전 값이 '중립'이라면 마지막 값은 '중립'이 되어야 한다.")
    @Test
    void lineGenerateTestByLastBeforeNeutral() {
        //given
        int width = 2;
        int firstIndex = 0;
        int secondIndex = 1;
        LineGenerator lineGenerator = new LineGenerator(new NeutralDirectionGenerator());
        Line line = lineGenerator.generate(width);
        List<Direction> directionsInfo = line.getDirectionsInfo();

        //when
        Direction firstLineDirection = directionsInfo.get(firstIndex);
        Direction secondLineDirection = directionsInfo.get(secondIndex);

        //then
        assertThat(firstLineDirection).isEqualTo(Direction.NEUTRAL);
        assertThat(secondLineDirection).isEqualTo(Direction.NEUTRAL);
    }
}
