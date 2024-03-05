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

class ResultsTest {

    private final RandomPointsGenerator firstLevelPointsGenerator = new RandomPointsGenerator() {
        @Override
        public List<Point> generate(int size) {
            return List.of(Point.ON, Point.OFF, Point.ON, Point.OFF);
        }
    };

    private final RandomPointsGenerator secondLevelPointsGenerator = new RandomPointsGenerator() {
        @Override
        public List<Point> generate(int size) {
            return List.of(Point.OFF, Point.ON, Point.OFF, Point.OFF);
        }
    };

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        Line line1 = new Line(firstLevelPointsGenerator.generate(4));
        Line line2 = new Line(secondLevelPointsGenerator.generate(4));

        ladder = new Ladder(List.of(line1, line2));
    }

    @Test
    @DisplayName("사다리가 모두 탔을 때 도착한 곳이 실행 결과이다.")
    void find_ResultPosition_IsResult() {
        // given
        Results results = new Results(List.of("꽝", "5000", "꽝", "3000"));
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
        Results results = new Results(List.of("꽝", "5000", "꽝", "3000"));

        // when
        int startPosition = players.findPosition(new Player("crong"));
        int resultPosition = ladder.ride(startPosition);
        Result result = results.find(resultPosition);

        // then
        assertThat(result.toString()).isEqualTo("3000");
    }

    @Test
    @DisplayName("결과 수가 사람보다 적다면 같을 때 까지 복사한다.")
    void refactor_LessThanPlayersCount_Repeat() {
        // given
        Results results = new Results(List.of("꽝", "5000"));

        // when
        results.refactor(5);

        // then
        assertThat(results.getResults()).hasSize(5);
    }

    @Test
    @DisplayName("결과 수가 사람보다 많다면 사람 수 만큼 자른다.")
    void refactor_MoreThanPlayersCount_SubList() {
        // given
        Results results = new Results(List.of("꽝", "5000", "꽝", "3000"));

        // when
        results.refactor(3);

        // then
        assertThat(results.getResults()).hasSize(3);
    }
}
