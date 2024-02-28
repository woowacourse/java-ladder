package model;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

    @DisplayName("참가자로부터 게임 결과를 얻는다.")
    @Test
    void findResult() {
        LadderGame ladderGame = new LadderGame();
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
