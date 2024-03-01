package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void createLadderGame() {
        Players players = new Players("pobi", "honux", "crong", "jk");
        ResultItems resultItems = new ResultItems(4, "꽝", "5000", "꽝", "3000");
        /*
        |-----|     |-----|
        |     |-----|     |
        |-----|     |     |
        |     |-----|     |
        |-----|     |-----|
         */
        Ladder ladder = new Ladder(
                5,
                new Line(4, Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT),
                new Line(4, Direction.DOWN, Direction.RIGHT, Direction.LEFT, Direction.DOWN),
                new Line(4, Direction.RIGHT, Direction.LEFT, Direction.DOWN, Direction.DOWN),
                new Line(4, Direction.DOWN, Direction.RIGHT, Direction.LEFT, Direction.DOWN),
                new Line(4, Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT)
        );

        ladderGame = new LadderGame(players, resultItems, ladder);
    }

    @DisplayName("모든 참여자의 사다리를 실행한다.")
    @Test
    void executeAll() {
        // when
        Map<Player, ResultItem> result = ladderGame.execute("all");

        // then
        assertThat(result).containsExactlyEntriesOf(new LinkedHashMap<>() {{
            put(new Player("pobi"), new ResultItem("꽝"));
            put(new Player("honux"), new ResultItem("3000"));
            put(new Player("crong"), new ResultItem("꽝"));
            put(new Player("jk"), new ResultItem("5000"));
        }});
    }

    @DisplayName("특정 참여자의 사다리를 실행한다.")
    @ParameterizedTest
    @CsvSource(value = {"pobi, 꽝", "honux, 3000", "crong, 꽝", "jk, 5000"})
    void executeOne(String target, String resultItem) {
        // when
        Map<Player, ResultItem> result = ladderGame.execute(target);

        // then
        assertThat(result).containsExactlyEntriesOf(Map.of(
                new Player(target), new ResultItem(resultItem)));
    }

    @DisplayName("참여하지 않은 사람의 사다리를 실행한다.")
    @Test
    void executeWithNonPlayer() {
        // when
        assertThatThrownBy(() -> ladderGame.execute("pobi1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
