package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameResultTest {
    @Test
    void 결과를_제대로_저장하는지_확인() {
        Map<String, String> result = new HashMap<>();
        result.put("pobi", "1000");
        result.put("cu", "100");
        LadderGameResult ladderGameResult = new LadderGameResult(result);

        assertThat(ladderGameResult.prize("pobi")).isEqualTo("1000");
        assertThat(ladderGameResult.allPrizes()).isEqualTo(result);
    }
}