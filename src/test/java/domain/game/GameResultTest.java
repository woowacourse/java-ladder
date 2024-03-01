package domain.game;

import domain.result.Result;
import domain.user.UserName;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class GameResultTest {

    @Test
    @DisplayName("사용자의 이름을 통해 실행 결과를 반환한다.")
    void findResultByUserName() {
        //given
        GameResult gameResult = new GameResult(new HashMap<>());
        UserName userName = new UserName("pobi");
        Result result = new Result("꽝");
        //when
        gameResult.save(userName.toString(), result.toString());
        //then
        Assertions.assertThat(gameResult.findByUserName(userName.toString()))
                .isEqualTo(result.toString());
    }
}
