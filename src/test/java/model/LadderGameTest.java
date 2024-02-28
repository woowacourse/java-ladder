package model;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

    @DisplayName("참가자로부터 게임 결과를 얻는다.")
    @Test
    void findResult() {
        //TODO: participant를 ladder에 넣지 않는다. size만 넣을 것
        LadderGame ladderGame = createLadderGame();
        String zeroResult = ladderGame.findParticipantResult(new Name("0"));
        String oneResult = ladderGame.findParticipantResult(new Name("1"));
        String secondResult = ladderGame.findParticipantResult(new Name("2"));
        String thirdResult = ladderGame.findParticipantResult(new Name("3"));
        String forthResult = ladderGame.findParticipantResult(new Name("4"));

        assertAll(
                ()->Assertions.assertThat(zeroResult).isEqualTo("꽝"),
                ()->Assertions.assertThat(oneResult).isEqualTo("5000"),
                ()->Assertions.assertThat(secondResult).isEqualTo("꽝"),
                ()->Assertions.assertThat(thirdResult).isEqualTo("3000"),
                ()->Assertions.assertThat(forthResult).isEqualTo("꽝")
        );
    }

    private static LadderGame createLadderGame() {
        Ladder ladder = new Ladder(List.of(
                new LadderRow(List.of(true, false, false, true)),
                new LadderRow(List.of(true, false, true, false))));
        Participants participants = new Participants(List.of("0", "1", "2", "3", "4"));
        Map<Integer, String> result = new LinkedHashMap<>();
        result.put(0, "꽝");
        result.put(1, "5000");
        result.put(2, "꽝");
        result.put(3, "꽝");
        result.put(4, "3000");
        LadderGame ladderGame = new LadderGame(participants, ladder, result);
        return ladderGame;
    }

    /*
         0     1     2     3     4
         |-----|     |     |-----|
         |-----|     |-----|     |
         0     1     2     3     4
         꽝   5000   꽝     꽝   3000

         0 -> 0 꽝
         1 -> 1 5000
         2 -> 3 꽝
         3 -> 4 3000
         4 -> 2 꽝
     */

}
