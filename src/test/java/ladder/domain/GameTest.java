package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

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

    private People people;
    private Results results;
    private Ladder ladder;
    private final Result result1 = new Result("꽝");
    private final Result result2 = new Result("3000");
    private final Result result3 = new Result("꽝");
    private final Result result4 = new Result("5000");

    @BeforeEach
    void setUp() {
        Name pobi = new Name("pobi");
        Name honux = new Name("honux");
        Name crong = new Name("crong");
        Name jk = new Name("jk");
        people = new People(List.of(pobi, honux, crong, jk));

        results = new Results(List.of(
                result1, result2, result3, result4
        ), 4);

        Line line1 = new Line(pointsGenerator1.generate(3));
        Line line2 = new Line(pointsGenerator2.generate(3));
        ladder = new Ladder(List.of(line1, line2));
    }

    @Test
    @DisplayName("이름으로 실행 결과를 도출한다")
    void playOnTarget() {
        // given
        Game game = new Game(people, results, ladder);
        Name name = new Name("pobi");

        // when
        Map<Name, Result> playResults = game.play(name);

        // then
        Map<Name, Result> expected = Map.of(
                new Name("pobi"), result3
        );
        assertThat(playResults).containsAllEntriesOf(expected);
    }

    @Test
    @DisplayName("모든 이름으로 실행 결과를 도출한다")
    void playOnAllTarget() {
        // given
        Game game = new Game(people, results, ladder);
        Name all = new Name("all");

        // when
        Map<Name, Result> playResults = game.play(all);

        // then
        Map<Name, Result> expected = Map.of(
                new Name("pobi"), result3,
                new Name("honux"), result1,
                new Name("crong"), result4,
                new Name("jk"), result2
        );
        assertThat(playResults).containsAllEntriesOf(expected);
    }
}
