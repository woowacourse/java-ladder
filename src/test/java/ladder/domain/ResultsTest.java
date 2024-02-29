package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {

    private final RandomPointsGenerator pointsGenerator1 = new RandomPointsGenerator() {
        @Override
        public List<Point> generate(int size) {
            return List.of(Point.ON, Point.OFF, Point.ON);
        }
    };

    private final RandomPointsGenerator pointsGenerator2 = new RandomPointsGenerator() {
        @Override
        public List<Point> generate(int size) {
            return List.of(Point.OFF, Point.ON, Point.OFF);
        }
    };

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        Line line1 = new Line(pointsGenerator1.generate(3));
        Line line2 = new Line(pointsGenerator2.generate(3));

        ladder = new Ladder(List.of(line1, line2));
    }

    @Test
    @DisplayName("사다리가 모두 탔을 때 도착한 곳이 실행 결과이다.")
    void getResult() {
        // given
        Result result1 = new Result("꽝");
        Result result2 = new Result("3000");
        Result result3 = new Result("꽝");
        Result result4 = new Result("5000");
        Results results = new Results(List.of(
                result1, result2, result3, result4
        ), 4);
        int position = ladder.ride(0);

        // when
        Result result = results.find(position);

        // then
        assertThat(result).isEqualTo(result3);
    }

    @Test
    @DisplayName("이름을 입력하면 실행결과를 알 수 있다.")
    void findResultByName() {
        // given
        People people = new People(
                List.of(
                        new Name("pobi"),
                        new Name("honux"),
                        new Name("crong"),
                        new Name("jk")
                )
        );
        Result result1 = new Result("꽝");
        Result result2 = new Result("5000");
        Result result3 = new Result("꽝");
        Result result4 = new Result("3000");
        Results results = new Results(List.of(result1, result2, result3, result4), 4);

        int startPosition = people.findPosition(new Name("crong"));
        int resultPosition = ladder.ride(startPosition);

        // when
        Result result = results.find(resultPosition);

        // then
        assertThat(result).isEqualTo(result4);
    }

    @Test
    @DisplayName("결과의 수와 사람 수가 다르면 예외가 발생한다.")
    void resultCountExceptionTest() {
        // given
        People people = new People(
                List.of(
                        new Name("pobi"),
                        new Name("honux"),
                        new Name("crong")
                )
        );

        // when & then
        assertThatThrownBy(
                () -> new Results(List.of(new Result("꽝"), new Result("5000")), people.count())
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
