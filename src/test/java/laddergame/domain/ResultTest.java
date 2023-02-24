package laddergame.domain;

import laddergame.util.RandomPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    @DisplayName("result가 정상적으로 생성된다.")
    void resultCreateTest() {
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        int ladderHeight = 5;
        Ladder ladder = new Ladder(players.size(), ladderHeight, new RandomPointGenerator());
        Prizes prizes = new Prizes(List.of("꽝", "5000", "꽝", "3000"), players.size());

        assertDoesNotThrow(() -> new Result(players, ladder, prizes));
    }

}
