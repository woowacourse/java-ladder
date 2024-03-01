package domain.game;

import domain.ladder.Ladder;
import domain.user.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderGameTest {

    @Test
    @DisplayName("사다리 게임 테스트")
    void ladderGameTest() {
        //given
        Users users = new Users(List.of("pobi", "honux", "crong", "jk"));

        Results results = Results.of(List.of(
                        new Result("꽝"),
                        new Result("5000"),
                        new Result("꽝"),
                        new Result("3000")),
                users);


        Ladder ladder = Ladder.of(3, 4, () -> true);
        /*
                사다리 모양
                pobi  honux crong   jk
                |-----|     |-----|
                |-----|     |-----|
                |-----|     |-----|
                꽝    5000  꽝    3000
         */

        //when
        GameResult gameResult = new LadderGame(users, ladder, results).getResult();
        //then
        assertAll(
                () -> assertThat(gameResult.findByUserName("pobi")).isEqualTo("5000"),
                () -> assertThat(gameResult.findByUserName("honux")).isEqualTo("꽝"),
                () -> assertThat(gameResult.findByUserName("crong")).isEqualTo("3000"),
                () -> assertThat(gameResult.findByUserName("jk")).isEqualTo("꽝")
        );
    }
}
