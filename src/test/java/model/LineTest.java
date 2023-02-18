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
        //given
        Line line = new Line(new TestPointGenerator(new ArrayList<>(List.of(false, true, false))), 4);

        //when
        List<Boolean> result = line.getPoints();

        //then
        assertThat(result).isEqualTo(List.of(false, true, false));
    }

    @Test
    @DisplayName("각 포인트들은 랜덤하게 만드는 기능 테스트")
    void makePointsRandomlyTest() {
        //given
        Line line = new Line(new RandomPointGenerator(), 4);

        //when
        List<Boolean> result = line.getPoints();

        //then
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("한 라인에서 같은 포인트가 연속으로 등장하지 않는 기능 테스트")
    void noContinuouslySamePointTest() {
        //given
        Line line = new Line(new TestPointGenerator(new ArrayList<>(List.of(true, true, true, true, true))), 6);

        //when
        List<Boolean> result = line.getPoints();

        //then
        assertThat(result).isEqualTo(List.of(true, false, true, false, true));

    }

    private static class TestPointGenerator implements PointGenerator {
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
