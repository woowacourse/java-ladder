package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {


    @Test
    @DisplayName("사다리게임은 한번에 모든 참가자들의 경품을 최초 한번 계산한다.")
    void calculatePrizeTest() {
        //given
        Ladder ladder = new Ladder(() -> true, "5", 3);
        People people = new People("프람, 호티, 제우스");
        List<Prize> expect = List.of(new Prize("당첨"), new Prize("꽝"), new Prize("다음"));

        //when
        LadderGame ladderGame = new LadderGame(people, ladder, "꽝,당첨,다음");
        List<Prize> actual = ladderGame.getRewardBoard().findAllPrizes();

        //then
        assertThat(actual).isEqualTo(expect);
    }
}
