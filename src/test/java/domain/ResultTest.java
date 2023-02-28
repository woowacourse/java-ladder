package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ResultTest {
    /**
     * 사다리 실행결과
     * pobi : 꽝
     * honux : 3000
     * crong : 꽝
     * jk : 5000
     */
    @Test
    @DisplayName("유저 이름으로 게임 결과를 조회하면 그에 맞는 결과값을 반환한다.")
    void userLadderGameResultTest() {
        //given
        Map<String, Integer> ladderGameResult = new LinkedHashMap<>();
        ladderGameResult.put("pobi", 0);
        ladderGameResult.put("honux", 3);
        ladderGameResult.put("crong", 2);
        ladderGameResult.put("jk", 1);

        final WinningResults winningResults = new WinningResults(List.of(new WinningResult("꽝"), new WinningResult("5000"), new WinningResult("꽝"), new WinningResult("3000")));
        Result result = Result.of(winningResults, ladderGameResult);

        //when
        final Map<String, WinningResult> pobiGameResult = result.getResult("pobi");
        final Map<String, WinningResult> honuxGameResult = result.getResult("honux");
        final Map<String, WinningResult> crongGameResult = result.getResult("crong");
        final Map<String, WinningResult> jkGameResult = result.getResult("jk");

        //then
        Assertions.assertThat(pobiGameResult.get("pobi").getWinningResult()).isEqualTo("꽝");
        Assertions.assertThat(honuxGameResult.get("honux").getWinningResult()).isEqualTo("3000");
        Assertions.assertThat(crongGameResult.get("crong").getWinningResult()).isEqualTo("꽝");
        Assertions.assertThat(jkGameResult.get("jk").getWinningResult()).isEqualTo("5000");
    }
}
