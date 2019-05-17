package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerGroupTest {
    @Test
    void 플레이어_그룹이_잘_생성되는지_테스트() {
        List<String> playerNames = Arrays.asList("a,b".split(","));
        assertThat(new PlayerGroup(playerNames)).isEqualTo(new PlayerGroup(playerNames));
    }

    @Test
    void 플레이어_수를_제대로_돌려주는지_테스트() {
        PlayerGroup players = new PlayerGroup(Arrays.asList("a", "b", "c"));
        assertThat(players.size()).isEqualTo(3);
    }

    @Test
    void 중복된_이름이_입력되었을_떄_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new PlayerGroup(Arrays.asList("a", "c", "c")));
    }

    @Test
    void 모든_플레이어의_결과가_HashMap으로_잘_나오는지_테스트() {
        List<Boolean> userSetCroossbar = Arrays.asList(false, true, false);
        List<ResultItem> resultItems = Arrays.asList(new ResultItem("a"), new ResultItem("b"));
        Ladder testLadder = new Ladder(1, resultItems,
                new UserSetCrossbarGenerator(userSetCroossbar));
        List<String> playerNames = Arrays.asList("van,deock".split(","));
        PlayerGroup players = new PlayerGroup(playerNames);

        assertThat(players.findLadderingResult(testLadder).get("van")).isEqualTo(new ResultItem("b"));
        assertThat(players.findLadderingResult(testLadder).get("deock")).isEqualTo(new ResultItem("a"));

    }
}
