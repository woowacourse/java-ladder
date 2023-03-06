package domain.result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.player.Names;
import domain.player.Players;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("게임 결과는")
class ResultTest {

    @Test
    @DisplayName("해당 이름의 플레이어가 있으면 결과를 반환하다.")
    void gameResultTest() {
        //given
        Players players = new Players(new Names(List.of("pobi", "crong", "bkcat")));
        Prizes prizes = new Prizes(List.of("꽝", "5000", "1500"));

        //when
        Result result = new Result(players, prizes);

        //then
        assertThat(result.queryByPlayer("pobi"))
                .isEqualTo(new Prize("꽝").toString());
    }


    @Test
    @DisplayName("해당 이름의 플레이어가 없으면")
    void inValidGameResultTest() {
        //given
        Players players = new Players(new Names(List.of("pobi", "crong", "bkcat")));
        Prizes prizes = new Prizes(List.of("꽝", "5000", "1500"));

        //when
        Result result = new Result(players, prizes);

        //then
        assertThatThrownBy(() -> result.queryByPlayer("pobz"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("pobz란, 플레이어는 없습니다.");

    }


}
