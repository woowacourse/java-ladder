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
    private ResultItems resultItems;

    @BeforeEach
    void createLadderGame() {
        Players players = new Players("pobi", "honux", "crong", "jk");
        resultItems = new ResultItems(4, "꽝", "5000", "꽝", "3000");
        /*
        |-----|     |-----|
        |     |-----|     |
        |-----|     |     |
        |     |-----|     |
        |-----|     |-----|
         */
        Ladder ladder = new Ladder(
                5,
                new Line(4, Direction.FORWARD, Direction.BACKWARD, Direction.FORWARD, Direction.BACKWARD),
                new Line(4, Direction.STAY, Direction.FORWARD, Direction.BACKWARD, Direction.STAY),
                new Line(4, Direction.FORWARD, Direction.BACKWARD, Direction.STAY, Direction.STAY),
                new Line(4, Direction.STAY, Direction.FORWARD, Direction.BACKWARD, Direction.STAY),
                new Line(4, Direction.FORWARD, Direction.BACKWARD, Direction.FORWARD, Direction.BACKWARD)
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
            put(new Player("pobi"), resultItems.get(new Index(0)));
            put(new Player("honux"), resultItems.get(new Index(3)));
            put(new Player("crong"), resultItems.get(new Index(2)));
            put(new Player("jk"), resultItems.get(new Index(1)));
        }});
    }

    @DisplayName("특정 참여자의 사다리를 실행한다.")
    @ParameterizedTest
    @CsvSource(value = {"pobi, 0", "honux, 3", "crong, 2", "jk, 1"})
    void executeOne(String target, int resultItemsIndex) {
        // when
        Map<Player, ResultItem> result = ladderGame.execute(target);

        // then
        assertThat(result).containsExactlyEntriesOf(Map.of(
                new Player(target), resultItems.get(new Index(resultItemsIndex))));
    }

    @DisplayName("참여하지 않은 사람의 사다리를 실행한다.")
    @Test
    void executeWithNonPlayer() {
        // when
        assertThatThrownBy(() -> ladderGame.execute("pobi1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
