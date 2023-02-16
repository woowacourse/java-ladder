import domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import util.TrueOrFalseGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LineTest {
    Line line;

    @Nested
    @DisplayName("랜덤 값의 의한 라인 생성 테스트(첫번째 좌표는 이전 좌표가 없는것을 표시)")
    class Creat {
        @DisplayName("들어간대로 잘 생성되었는지 테스트")
        @Test
        void createTest() {
            line = new Line(4, new testTrueOrFalseGenerator(new ArrayList<>(Arrays.asList(false, true, false)) {
            }));
            assertThat(line.getPoints()).isEqualTo(List.of(false, true, false));
        }

        @DisplayName("이전 좌표와 현재 좌표가 겹칠때 변환 테스트(처)")
        @Test
        void createLine2() {
            line = new Line(4, new testTrueOrFalseGenerator(new ArrayList<>(Arrays.asList(true, true, false)) {
            }));
            assertThat(line.getPoints()).isEqualTo(List.of(true, false, false));
        }
    }


    static class testTrueOrFalseGenerator implements TrueOrFalseGenerator {
        List<Boolean> points;

        testTrueOrFalseGenerator(List<Boolean> points) {
            this.points = points;
        }

        @Override
        public boolean generate() {
            return points.remove(0);
        }
    }

}