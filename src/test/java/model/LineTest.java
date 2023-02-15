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
        assertThatNoException().isThrownBy(()->{Line line = new Line(new TestPointGenerator(new ArrayList<>(List.of(false,true,false))), 4);});
    }

    @Test
    @DisplayName("사다리 한 라인에 존재하는 포인트들을 만드는 기능 테스트")
    void makePointsInLineTest() {
        //Given
        Line line = new Line(new TestPointGenerator(new ArrayList<>(List.of(false,true,false))), 4);

        //When
        List<Boolean> result = line.getPoints();

        //Then
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("각 포인트들은 랜덤하게 만든다.")
    void makePointsRandomlyTest() {
        //Given
        Line line = new Line(new TestPointGenerator(new ArrayList<>(List.of(false,true,false))), 4);

        //When
        List<Boolean> result = line.getPoints();

        //Then
        assertThat(result).isEqualTo(List.of(false,true,false));
    }

    private class TestPointGenerator implements PointGenerator{

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
