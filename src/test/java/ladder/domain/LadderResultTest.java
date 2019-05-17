package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {
    @Test
    void 생성자확인() {
        List<Integer> allResult = Arrays.asList(0, 1, 2);
        List<String> names = Arrays.asList("pobi", "brown", "woni");
        List<String> resultCandidate = Arrays.asList("꽝", "5000", "꽝");
        LadderResult ladderResult = new LadderResult(allResult, names, resultCandidate);
        assertThat(ladderResult).isEqualTo(new LadderResult(allResult, names, resultCandidate));
    }

    @Test
    void 결과_출력() {
        List<Integer> allResult = Arrays.asList(0, 1, 2);
        List<String> names = Arrays.asList("pobi", "brown", "woni");
        List<String> resultCandidate = Arrays.asList("꽝", "5000", "꽝");
        LadderResult ladderResult = new LadderResult(allResult, names, resultCandidate);
        assertThat(ladderResult.matchResult("woni")).isEqualTo("꽝");
        assertThat(ladderResult.matchResult("all")).isEqualTo("pobi : 꽝\nbrown : 5000\nwoni : 꽝\n");
    }
}
