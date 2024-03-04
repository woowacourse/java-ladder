package ladder.domain.result;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;
import ladder.domain.ladder.RandomPointsGenerator;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
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
            return List.of(Point.ON, Point.OFF, Point.ON, Point.OFF);
        }
    };

    private final RandomPointsGenerator pointsGenerator2 = new RandomPointsGenerator() {
        @Override
        public List<Point> generate(int size) {
            return List.of(Point.OFF, Point.ON, Point.OFF, Point.OFF);
        }
    };

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        Line line1 = new Line(pointsGenerator1.generate(4));
        Line line2 = new Line(pointsGenerator2.generate(4));

        ladder = new Ladder(List.of(line1, line2));
    }

    @Test
    @DisplayName("사다리가 모두 탔을 때 도착한 곳이 실행 결과이다.")
    void find_ResultPosition_IsResult() {
        // given
        Results results = new Results(List.of("꽝", "5000", "꽝", "3000"), 4);
        int position = ladder.ride(0);

        // when
        Result result = results.find(position);

        // then
        assertThat(result).isEqualTo(new Result("꽝"));
    }

    @Test
    @DisplayName("참여자를 입력하면 실행결과를 알 수 있다.")
    void find_Player_Result() {
        // given
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Results results = new Results(List.of("꽝", "5000", "꽝", "3000"), 4);

        // when
        int startPosition = players.findPosition(new Player("crong"));
        int resultPosition = ladder.ride(startPosition);
        Result result = results.find(resultPosition);

        // then
        assertThat(result.toString()).isEqualTo("3000");
    }

    @Test
    @DisplayName("결과의 수와 사람 수가 다르면 예외가 발생한다.")
    void results_DifferentPlayersCount_ExceptionThrown() {
        // given
        Players players = new Players(List.of("pobi", "honux", "crong"));

        // when & then
        assertThatThrownBy(
                () -> new Results(List.of("꽝", "5000"), players.count())
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
