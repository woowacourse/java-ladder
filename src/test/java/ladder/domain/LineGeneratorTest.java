package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineGeneratorTest {

    @DisplayName("정해진 수만큼 라인의 너비를 가지는 라인을 생성한다.")
    @Test
    void lineGenerateTest() {
        //given
        int width = 5;
        LineGenerator lineGenerator = new LineGenerator(new DirectionGeneratorImpl());
        Line line = lineGenerator.generate(width);
        List<Direction> directionsInfo = line.getDirectionsInfo();

        //when, then
        assertThat(directionsInfo).hasSize(width);
    }

    @DisplayName("라인의 첫번째 값에는 '오른쪽' 또는 '중립'만 올 수 있다.")
    @Test
    void lineGenerateTestByFirstValue() {
        //given
        int firstIndex = 0;
        LineGenerator lineGenerator = new LineGenerator(new DirectionGeneratorImpl());
        Line line = lineGenerator.generate(1);
        List<Direction> directionsInfo = line.getDirectionsInfo();

        //when
        Direction direction = directionsInfo.get(firstIndex);

        //when, then
        assertThat(direction).isNotEqualTo(Direction.LEFT);
    }

    @DisplayName("라인의 두번째 값 부터는 이전의 값이 '오른쪽'이라면 다음 값은 무조건 '왼쪽'이 와야 한다.")
    @Test
    void lineGenerateTestByRightBeforeLeft() {
        //given
        int firstIndex = 0;
        int secondIndex = 1;
        LineGenerator lineGenerator = new LineGenerator(new DirectionRightGeneratorImpl());
        Line line = lineGenerator.generate(2);
        List<Direction> directionsInfo = line.getDirectionsInfo();

        //when
        Direction firstLineDirection = directionsInfo.get(firstIndex);
        Direction secondLineDirection = directionsInfo.get(secondIndex);

        //when, then
        assertThat(firstLineDirection).isEqualTo(Direction.RIGHT);
        assertThat(secondLineDirection).isEqualTo(Direction.LEFT);
    }

    @DisplayName("라인에서 이전 값이 '왼쪽'이라면 다음 값은 '오른쪽' 또는 '중립'이 되어야 한다.")
    @Test
    void lineGenerateTestByRNBeforeLeft() {//수정 필요
        //given
        int secondIndex = 1;
        int thirdIndex = 2;
        LineGenerator lineGenerator = new LineGenerator(new DirectionRightGeneratorImpl());
        Line line = lineGenerator.generate(3);
        List<Direction> directionsInfo = line.getDirectionsInfo();

        //when
        Direction secondLineDirection = directionsInfo.get(secondIndex);
        Direction thirdLineDirection = directionsInfo.get(thirdIndex);
        boolean isDirectionRN = (thirdLineDirection == Direction.RIGHT
                || thirdLineDirection == Direction.NEUTRAL);

        //when, then
        assertThat(secondLineDirection).isEqualTo(Direction.LEFT);
        assertThat(isDirectionRN).isTrue();
    }

    @DisplayName("라인에서 이전 값이 '중립'이라면 다음 값은 '오른쪽' 또는 '중립'이 되어야 한다.")
    @Test
    void lineGenerateTestByRNBeforeNeutral() {
        //given
        int firstIndex = 0;
        int secondIndex = 1;
        LineGenerator lineGenerator = new LineGenerator(new DirectionNeutralGeneratorImpl());
        Line line = lineGenerator.generate(2);
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
}
