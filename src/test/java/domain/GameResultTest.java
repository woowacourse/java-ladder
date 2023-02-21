package domain;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @DisplayName("게임 실행 결과를 생성한다.")
    @Test
    void getGameResult() {
        //given
        Participants participants = new Participants("ash,split,ako,mako,heero,bever");
        LadderResults ladderResults = new LadderResults("1000,2000,3000,4000,5000,6000");
        TestBooleanGenerator testBooleanGenerator = new TestBooleanGenerator();
        testBooleanGenerator.addAllValues(List.of(true, false, false, true, false));
        Ladder ladder = new Ladder("1", 5, testBooleanGenerator);
        //when
        GameResult gameResult = new GameResult(ladder, participants, ladderResults);
        //then
        Assertions.assertThat(gameResult.getResult()).containsAllEntriesOf(Map.of(
            "ash", "2000",
            "split", "1000",
            "ako", "3000",
            "mako", "4000",
            "heero", "6000",
            "bever", "5000"
        ));
    }
}
