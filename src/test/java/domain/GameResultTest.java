package domain;

import org.assertj.core.api.Assertions;
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
    void saveGameResult() {
        //given
        GameResult gameResult = new GameResult(new HashMap<>());
        UserName userName = new UserName("pobi");
        Result result = new Result("꽝");
        //when
        //then
        assertThatCode(() -> gameResult.save(userName.toString(), result.toString()))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사용자의 이름을 통해 실행 결과를 반환한다.")
    void findResultByUserName() {
        //given
        GameResult gameResult = new GameResult(new HashMap<>());
        UserName userName = new UserName("pobi");
        Result result = new Result("꽝");
        gameResult.save(userName.toString(), result.toString());
        //when

        //then
        Assertions.assertThat(gameResult.findByUserName(userName.toString()))
                .isEqualTo(result.toString());
    }


}
