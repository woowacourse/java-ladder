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
        Line line = LineGenerator.generate(width);
        List<Direction> directionsInfo = line.getDirectionsInfo();

        //when, then
        assertThat(directionsInfo).hasSize(width);
    }

    @DisplayName("라인의 첫번째 값에는 '오른쪽' 또는 '중립'만 올 수 있다.")
    @Test
    void lineGenerateTestByFirstValue() {
        //given
        int firstIndex = 0;
        Line line = LineGenerator.generate(1);
        List<Direction> directionsInfo = line.getDirectionsInfo();

        //when
        Direction direction = directionsInfo.get(firstIndex);

        //when, then
        assertThat(direction).isNotEqualTo(Direction.L);
    }

    @DisplayName("라인의 두번째 값 부터는 이전의 값이 '오른쪽'이라면 다음 값은 무조건 '왼쪽'이 와야 한다.")
    @Test
    void lineGenerateTestByRightBeforeLeft() {
        //given
        int firstIndex = 0;
        int secondIndex = 1;
        Line line = LineGenerator.generate(0);
        List<Direction> directionsInfo = line.getDirectionsInfo();
        directionsInfo.add(Direction.R);

        //when
        Direction firstLineDirection = directionsInfo.get(firstIndex);
        Direction secondLineDirection = directionsInfo.get(secondIndex);

        //when, then
        assertThat(firstLineDirection).isEqualTo(Direction.R);
        assertThat(secondLineDirection).isEqualTo(Direction.L);
    }

}
