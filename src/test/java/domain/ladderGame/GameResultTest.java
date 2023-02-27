package domain.ladderGame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

class GameResultTest {

    @Test
    @DisplayName("이름을 입력하면 해당 참가자의 실행 결과를 반환한다.")
    void getTargetResultTest() {
        LinkedHashMap<String, String> gameResultSetting = new LinkedHashMap<>();
        gameResultSetting.put("pobi", "당첨1");
        gameResultSetting.put("jk", "당첨2");
        gameResultSetting.put("crong", "당첨3");
        gameResultSetting.put("honux", "당첨4");

        LinkedHashMap<String, String> results = new GameResult(gameResultSetting).getResults();
        Assertions.assertThat(results.get("pobi")).isEqualTo("당첨1");
    }
}