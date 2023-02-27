package domain.ladder;

import domain.generator.MockBooleanGenerator;
import domain.player.Position;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private static MockBooleanGenerator booleanGenerator;
    private static Ladder ladder;

    /**
     * 생성된 사다리 모양
     *
     *     |-----|     |-----|
     *     |     |-----|     |
     */

    @Test
    @DisplayName("맨 왼쪽에 있다면 왼쪽으로 갈 수 없다.")
    void isLeftmost() {
        int order = 0;
        Position position = new Position(order);
        assertThat(ladder.isLeftPassable(position)).isFalse();
    }

    @Test
    @DisplayName("왼쪽에 다리가 있다면 왼쪽으로 갈 수 있다.")
    void canGoLeft() {
        int order = 1;
        Position position = new Position(order);
        assertThat(ladder.isLeftPassable(position)).isTrue();
    }

    @Test
    @DisplayName("맨 왼쪽이 아니면서 왼쪽에 다리가 없다면 왼쪽으로 갈 수 없다.")
    void cannotGoLeft() {
        int order = 2;
        Position position = new Position(order);
        assertThat(ladder.isLeftPassable(position)).isFalse();
    }

    @Test
    @DisplayName("맨 오른쪽에 있다면 오른쪽으로 갈 수 없다.")
    void isRightmost() {
        int order = 3;
        Position position = new Position(order);
        assertThat(ladder.isRightPassable(position)).isFalse();
    }

    @Test
    @DisplayName("오른쪽에 다리가 있다면 오른쪽으로 갈 수 있다.")
    void canGoRight() {
        int order = 2;
        Position position = new Position(order);
        assertThat(ladder.isRightPassable(position)).isTrue();
    }

    @Test
    @DisplayName("맨 오른쪽이 아니면서 오른쪽에 다리가 없다면 오른쪽으로 갈 수 없다.")
    void cannotGoRight() {
        int order = 1;
        Position position = new Position(order);
        assertThat(ladder.isRightPassable(position)).isFalse();
    }

    @BeforeAll
    static void setting() {
        booleanGenerator = new MockBooleanGenerator(
                List.of(true, false, true,
                        false, true, false));

        ladder = new Ladder(makeTestLadder());
    }

    private static List<Line> makeTestLadder() {
        return List.of(
                new Line(4, booleanGenerator),
                new Line(4, booleanGenerator));
    }
}