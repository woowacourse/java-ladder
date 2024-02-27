package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static domain.Bridge.BRIDGE;
import static domain.Bridge.NON_BRIDGE;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    @DisplayName("사다리 게임 테스트")
    void ladderGameTest() {
        //given
        Users users = new Users(List.of("pobi", "honux", "crong", "jk"));

        Results results = new Results(List.of(
                new Result("꽝"),
                new Result("5000"),
                new Result("꽝"),
                new Result("3000")));


        Ladder ladder = new Ladder(List.of(
                new Line(List.of(BRIDGE, NON_BRIDGE, BRIDGE)),
                new Line(List.of(NON_BRIDGE, BRIDGE, NON_BRIDGE)),
                new Line(List.of(BRIDGE, NON_BRIDGE, NON_BRIDGE)),
                new Line(List.of(NON_BRIDGE, BRIDGE, NON_BRIDGE)),
                new Line(List.of(BRIDGE, NON_BRIDGE, BRIDGE)))
        );

        /*
                사다리 모양
                pobi  honux crong   jk
                |-----|     |-----|
                |     |-----|     |
                |-----|     |     |
                |     |-----|     |
                |-----|     |-----|
                꽝    5000  꽝    3000
         */

        //when
        GameResult gameResult = new LadderGame(users, ladder, results).getResult();
        //then
        assertAll(
                () -> assertThat(gameResult.findByUserName("pobi")).isEqualTo("꽝"),
                () -> assertThat(gameResult.findByUserName("honux")).isEqualTo("3000"),
                () -> assertThat(gameResult.findByUserName("crong")).isEqualTo("꽝"),
                () -> assertThat(gameResult.findByUserName("jk")).isEqualTo("5000")
        );
    }

}
