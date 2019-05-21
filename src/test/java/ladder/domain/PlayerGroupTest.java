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
    void 플레이어와_매칭된_LadderingResult가_정상적으로_반환되는지_테스트() {
        PlayerGroup players = new PlayerGroup(Arrays.asList("a", "b"));
        List<Boolean> userSetCroossbar = Arrays.asList(false, true, false);
        ResultItems resultItems = new ResultItems(Arrays.asList("1", "2"), 2);
        Ladder testLadder = new Ladder(1, new UserSetLadderRowGenerator(userSetCroossbar), 2);
        List<Integer> ladderingResultItemsIndex = testLadder.getLadderingResultItemsIndex(2);

        LadderResult ladderResult = new LadderResult();
        ladderResult.addResult(new Player("a", 0), new ResultItem("2"));
        ladderResult.addResult(new Player("b", 1), new ResultItem("1"));
        assertThat(players.matchLadderingResult(resultItems, ladderingResultItemsIndex)).isEqualTo(ladderResult);
    }
}
