package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.GameStrategy;
import util.LineGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameTest {
    private static Names names;
    private static LadderGoal goal;
    private static LadderHeight height;
    private static List<Boolean> randomLine;
    private static Ladder ladder;
    private static GameStrategy gameStrategy;

    @BeforeEach
    void beforeEach() {
        names = new Names("pobi,honux,crong");
        goal = new LadderGoal("꽝,10000,꽝", names.getNamesSize());
        height = new LadderHeight(1);
        randomLine = new ArrayList<>(List.of(false, false));
        ladder = new Ladder(names.getNamesSize(), height,
                new LineTest.TestLineGenerator(randomLine));
        gameStrategy = new TestLadderGameStrategy(ladder);
    }

    @Test
    @DisplayName("Game 객체 생성 성공 테스트")
    void createGameTest() {
        Ladder ladder = new Ladder(names.getNamesSize(), height, new LineGenerator());

        Assertions.assertThatNoException().isThrownBy(
                () -> new Game(names, goal, ladder, gameStrategy)
        );
    }

    @ParameterizedTest(name = "Game 결과 호출 성공 테스트 name = {0}")
    @CsvSource(value = {"pobi:꽝", "honux:10000", "crong:꽝"}, delimiter = ':')
    void getGamePrizeTest(String input, String prize) {
        Game game = new Game(names, goal, ladder, gameStrategy);

        Assertions.assertThat(game.getPrizeIndividualWinner(new Winner(names, input))).isEqualTo(prize);
    }

    @Test
    @DisplayName("Game 결과 전체 호출 성공 테스트")
    void getGamePrizeAllTest() {
        Game game = new Game(names, goal, ladder, gameStrategy);

        Assertions.assertThatNoException().isThrownBy(() -> game.getPrizeWinners());
    }

    static class TestLadderGameStrategy implements GameStrategy {
        private Map<Integer, Integer> prizeResult = new HashMap<>();

        public TestLadderGameStrategy(Ladder ladder) {
            this.prizeResult = playGame(ladder);
        }

        @Override
        public Map<Integer, Integer> playGame(Ladder ladder) {
            int personCount = ladder.getLadderLineSize(0) + 1;
            for (int index = 0; index < personCount; index++) {
                prizeResult.put(index, index);
            }
            return prizeResult;
        }
    }
}
