package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
    @Test
    void 플레이어의_이름이_5자_이하일_때_정상적으로_생성되는지_테스트() {
        assertThat(new Player("qweas")).isEqualTo(new Player("qweas"));
    }

    @Test
    void 플레이어의_이름이_5자보다_클_때_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Player("qweasd"));
    }

    @Test
    void 플레이어의_이름이_공백으로만_이루어져_았을_때_얘외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Player(" "));
    }

    @Test
    void 플레이어의_이름이_null일_때_얘외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Player(null));
    }

    @Test
    void 플레이어의_이름이_all일_때_얘외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Player("all"));
    }

    @Test
    void 플레이어가_사다리를_다_내려간_결과와_자신의_이름을_반환하는지_테스트() {
        List<Boolean> userSetCroossbar = Arrays.asList(false, true, false);
        List<ResultItem> resultItems = Arrays.asList(new ResultItem("a"), new ResultItem("b"));
        Ladder testLadder = new Ladder(1, resultItems,
                new UserSetCrossbarGenerator(userSetCroossbar));
        Player player = new Player("van", 0);
        Player player2 = new Player("duck", 1);

        assertThat(player.stepDown(testLadder).get("van")).isEqualTo(new ResultItem("b"));
        assertThat(player2.stepDown(testLadder).get("duck")).isEqualTo(new ResultItem("a"));
    }
}
