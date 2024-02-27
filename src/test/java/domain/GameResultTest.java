package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;

class GameResultTest {

    @Test
    @DisplayName("GameResult를 생성한다.")
    void createGameResult() {
        //given
        //when
        //then
        assertThatCode(() -> new GameResult(new HashMap<>()))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사용자 이름과 실행 결과를 저장한다.")
    void saveGameResult() throws Exception {
        //given
        GameResult gameResult = new GameResult(new HashMap<>());
        UserName userName = new UserName("pobi");
        Result result = new Result("꽝");
        //when
        //then
        assertThatCode(() -> gameResult.save(userName.toString(), result.getPrize()))
                .doesNotThrowAnyException();
    }


}
