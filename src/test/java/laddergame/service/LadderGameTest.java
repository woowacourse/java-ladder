package laddergame.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import laddergame.domain.GameResult;
import laddergame.domain.Results;
import laddergame.domain.Height;
import laddergame.domain.Ladder;
import laddergame.domain.Name;
import laddergame.domain.Point;
import laddergame.domain.User;
import laddergame.domain.Users;
import laddergame.utils.LineMaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        Height ladderHeight = new Height(3);
        int userCount = 4;
        Ladder ladder = new Ladder(ladderHeight, userCount, new FixedLineMaker());

        Users users = new Users(List.of(new User(new Name("민트")), new User(new Name("헙크")),
                new User(new Name("쥬니")), new User(new Name("테오"))
        ));

        Results results = new Results(
                List.of(new GameResult("꽝"), new GameResult("3000원"), new GameResult("5000원"), new GameResult("8000원")),
                userCount
        );

        ladderGame = new LadderGame(ladder, users, results);
    }

    @Test
    void play() {
        Map<String, String> gameResultByUserName = ladderGame.play();

        Map<String, String> expected = new LinkedHashMap<>();
        expected.put("민트", "3000원");
        expected.put("헙크", "꽝");
        expected.put("쥬니", "8000원");
        expected.put("테오", "5000원");

        assertThat(gameResultByUserName).isEqualTo(expected);
    }

    private class FixedLineMaker implements LineMaker {

        @Override
        public List<Point> generateLine(int userCount) {
            return List.of(new Point(true)
                    , new Point(false)
                    , new Point(true));
        }
    }
}
