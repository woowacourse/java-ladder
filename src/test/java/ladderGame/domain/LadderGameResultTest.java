package ladderGame.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderGameResultTest {

    @Test
    void 해당_이름_결과값_반환() {
        LadderGameResult ladderGameResult = new LadderGameResult(Arrays.asList("꽝", "5000")
                , Arrays.asList(new User("pobi", 0), new User("crong", 1)));
        assertThat(ladderGameResult.getResultByName("pobi")).isEqualTo("꽝");
        assertThat(ladderGameResult.getResultByName("crong")).isEqualTo("5000");
    }
}
