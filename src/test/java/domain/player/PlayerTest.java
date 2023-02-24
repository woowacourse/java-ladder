package domain.player;

import static domain.ladder.LinePoint.BLOCKED;
import static domain.ladder.LinePoint.PASSABLE;
import static org.assertj.core.api.Assertions.assertThat;

import domain.ladder.Ladder;
import domain.ladder.Line;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerTest {

    @DisplayName("이름이 같으면 true를 반환한다.")
    @Test
    void same_name_return_true() {
        // given
        Name name = new Name("name");
        Player player = new Player(name, new Position(1));

        // then
        assertThat(player.isSameName("name")).isTrue();
    }

    @DisplayName("이름이 다르면 false를 반환한다.")
    @Test
    void different_name_return_false() {
        // given
        Name name = new Name("name");
        Player player = new Player(name, new Position(1));

        // then
        assertThat(player.isSameName("differentName")).isFalse();
    }

    /**
     * pobi  neo   me    ohs   hello
     * |-----|     |-----|     |
     * |     |-----|     |-----|
     * |     |-----|     |-----|
     * |     |-----|     |-----|
     */
    @DisplayName("move()를 통해 게임 결과에 맞는 positon을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:3", "2:1", "3:5", "4:2", "5:4"}, delimiter = ':')
    void move_result_test(int startPosition, int expectedPosition) {
        // given
        Ladder ladder = new Ladder(createLine());
        Player player = new Player(new Name("hs"), new Position(startPosition));

        // when
        Position actualPosition = player.move(ladder);

        // then
        assertThat(actualPosition).isEqualTo(new Position(expectedPosition));
    }

    private List<Line> createLine() {
        return List.of(
                new Line(List.of(PASSABLE, BLOCKED, PASSABLE, BLOCKED)),
                new Line(List.of(BLOCKED, PASSABLE, BLOCKED, PASSABLE)),
                new Line(List.of(BLOCKED, PASSABLE, BLOCKED, PASSABLE)),
                new Line(List.of(BLOCKED, PASSABLE, BLOCKED, PASSABLE)));
    }
}
