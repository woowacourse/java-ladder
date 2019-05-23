package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {

    @Test
    void all을_입력할_경우_모든_결과를_리턴해_준다() {
        PlayerGroup playerGroup = new PlayerGroup(Arrays.asList("a,b,c".split(",")));
        ResultItems resultItems = new ResultItems(Arrays.asList("1,2,3".split(",")), 3);
        List<Integer> ladderingResultItemsIndex = Arrays.asList(0, 1, 2);
        LadderResult lAdderResult = new LadderResult(playerGroup, resultItems, ladderingResultItemsIndex);
        assertThat(lAdderResult.getResultAll().size()).isEqualTo(3);
    }
}
