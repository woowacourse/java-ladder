package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

//    @DisplayName("라인에 사람의 수 - 1만큼 좌표를 생성한다.")
//    @Test
//    void createLine() {
//        // given
//        int personCount = 5;
//
//        // when
//        Line line = new Line(personCount, new RandomPointsGenerator());
//        int pointsSize = line.getPoints().size();
//
//        // then
//        assertThat(pointsSize).isEqualTo(personCount - 1);
//    }
//
//    @DisplayName("좌표가 하나 이상 사용되어야 한다.")
//    @Test
//    void createAllUnusedPoints() {
//        // when & then
//        assertThatIllegalArgumentException()
//                .isThrownBy(() -> new Line(Point.UNUSED, Point.UNUSED, Point.UNUSED, Point.UNUSED));
//    }
//
//    @DisplayName("좌표가 연속적으로 사용되어서는 안 된다.")
//    @Test
//    void createConsecutiveUsage() {
//        // when & then
//        assertThatIllegalArgumentException()
//                .isThrownBy(() -> new Line(Point.USED, Point.USED, Point.UNUSED, Point.UNUSED));
//    }
//
//    @DisplayName("사용된 좌표의 인덱스를 찾는다.")
//    @Test
//    void findUsedPointIndexes() {
//        // given
//        Line line = new Line(Point.USED, Point.UNUSED, Point.USED, Point.UNUSED);
//
//        // when
//        List<Integer> usedPointIndexes = line.findUsedPointIndexes();
//
//        // then
//        assertThat(usedPointIndexes).isEqualTo(List.of(0, 2));
//    }
//
//    @DisplayName("특정 좌표의 사용 여부를 확인한다.")
//    @ParameterizedTest
//    @CsvSource(value = {"0, true", "1, false", "2, true", "3, false"})
//    void isPointUsed(int index, boolean actual) {
//        // given
//        Line line = new Line(Point.USED, Point.UNUSED, Point.USED, Point.UNUSED);
//
//        // when
//        boolean expected = line.isPointUsed(index);
//
//        // then
//        assertThat(expected).isEqualTo(actual);
//    }

    @DisplayName("방향에 따라 이동한다.")
    @ParameterizedTest
    @CsvSource(value = {"0, 1", "1, 0", "2, 2"})
    void move(int indexValue, int actual) {
        // given
        Line line = new Line(Direction.RIGHT, Direction.LEFT, Direction.DOWN, Direction.DOWN);
        Index index = new Index(indexValue);

        // when
        Index expected = line.move(index);

        // then
        assertThat(expected.getValue()).isEqualTo(actual);
    }
}
