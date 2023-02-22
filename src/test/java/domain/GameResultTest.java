package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @DisplayName("게임 실행 결과를 생성한다.")
    @Test
    void getGameResult() {
        //given
        Participants participants = new Participants("ash,split,ako,mako,heero,bever");
        LadderResults ladderResults = new LadderResults("1000,2000,3000,4000,5000,6000", 6);
        TestBooleanGenerator testBooleanGenerator = new TestBooleanGenerator();
        testBooleanGenerator.addAllValues(List.of(true, false, false, true, false));
        Ladder ladder = new Ladder("1", 5, testBooleanGenerator);
        //when
        GameResult gameResult = new GameResult(ladder, participants, ladderResults);
        //then
        Assertions.assertThat(gameResult.getResultByName("ash")).isEqualTo("2000");
        Assertions.assertThat(gameResult.getResultByName("split")).isEqualTo("1000");
        Assertions.assertThat(gameResult.getResultByName("ako")).isEqualTo("3000");
        Assertions.assertThat(gameResult.getResultByName("mako")).isEqualTo("4000");
        Assertions.assertThat(gameResult.getResultByName("heero")).isEqualTo("6000");
        Assertions.assertThat(gameResult.getResultByName("bever")).isEqualTo("5000");
    }
}
