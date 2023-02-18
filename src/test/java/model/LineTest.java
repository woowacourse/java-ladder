package model;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LineTest {

    @Test
    @DisplayName("Line 객체 생성 성공 테스트")
    void createLineTest() {
        assertThatNoException().isThrownBy(() -> {
            new Line(new TestPointGenerator(new ArrayList<>(List.of(false, true, false))), 4);
        });
    }

    @Test
    @DisplayName("사다리 한 라인에 존재하는 포인트들을 만드는 기능 테스트")
    void makePointsInLineTest() {
        //Given
        Line line = new Line(new TestPointGenerator(new ArrayList<>(List.of(false, true, false))), 4);

        //When
        List<Boolean> result = line.getPoints();

        //Then
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("각 포인트들은 랜덤하게 만드는 기능 테스트")
    void makePointsRandomlyTest() {
        //Given
        Line line = new Line(new TestPointGenerator(new ArrayList<>(List.of(false, true, false))), 4);

        //When
        List<Boolean> result = line.getPoints();

        //Then
        assertThat(result).isEqualTo(List.of(false, true, false));
    }

    @Test
    @DisplayName("한 라인에서 같은 포인트가 연속으로 등장하지 않는 기능 테스트")
    void noContinuouslySamePointTest() {
        //Given
        Line line = new Line(new TestPointGenerator(new ArrayList<>(List.of(false, true, true, true))), 5);
        Line line2 = new Line(new TestPointGenerator(new ArrayList<>(List.of(true, true, true, true, true))), 6);

        //When
        List<Boolean> result = line.getPoints();
        List<Boolean> result2 = line2.getPoints();

        //Then
        assertThat(result).isEqualTo(List.of(false, true, false, true));
        assertThat(result2).isEqualTo(List.of(true, false, true, false, true));

    }

    private class TestPointGenerator implements PointGenerator {

        private final List<Boolean> points;

        public TestPointGenerator(List<Boolean> points) {
            this.points = new ArrayList<>(points);
        }

        @Override
        public boolean generate() {
            return points.remove(0);
        }

    }
}
