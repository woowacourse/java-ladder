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

    @BeforeEach
    void setUp() {
        Name pobi = new Name("pobi");
        Name honux = new Name("honux");
        Name crong = new Name("crong");
        Name jk = new Name("jk");
        people = new People(List.of(pobi, honux, crong, jk));

        results = new Results(List.of("꽝", "3000", "꽝", "5000"), 4);

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
        Map<Name, String> playResults = game.play(name);

        // then
        Map<Name, String> expected = Map.of(
                new Name("pobi"), "꽝"
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
        Map<Name, String> playResults = game.play(all);

        // then
        Map<Name, String> expected = Map.of(
                new Name("pobi"), "꽝",
                new Name("honux"), "꽝",
                new Name("crong"), "5000",
                new Name("jk"), "3000"
        );
        assertThat(playResults).containsAllEntriesOf(expected);
    }
}
