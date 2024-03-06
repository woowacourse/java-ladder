package laddergame.domain;

import laddergame.domain.connectiongenerator.AllFalseConnectionGenerator;
import laddergame.domain.connectiongenerator.TrueFalseConnectionGenerator;
import laddergame.domain.gameelements.Player;
import laddergame.domain.gameelements.Players;
import laddergame.domain.gameelements.Prize;
import laddergame.domain.gameelements.Prizes;
import laddergame.domain.ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LadderGameTest {
    static Stream<Arguments> ladderGameResultTest() {

        /*     [case1]              [case2]
         *     a    b    c          a    b    c
         *     |----|    |          |    |    |
         *     꽝   10   20         꽝   10   20
         *
         *     case1 예상결과 : a-10 / b-꽝 / c-20
         *     case2 예상결과 : a-꽝 / b-10 / c-20
         * */

        return Stream.of(
                arguments(
                        new Players(List.of("a", "b", "c"))
                        , new Prizes(List.of("꽝", "10", "20"), 3)
                        , new Ladder(1, 3, new TrueFalseConnectionGenerator())
                        , Stream.of(new String[][]{{"a", "10"}, {"b", "꽝"}, {"c", "20"},
                        }).collect(toMap(data -> data[0], data -> data[1])))

                , arguments(
                        new Players(List.of("a", "b", "c"))
                        , new Prizes(List.of("꽝", "10", "20"), 3)
                        , new Ladder(1, 3, new AllFalseConnectionGenerator())
                        , Stream.of(new String[][]{{"a", "꽝"}, {"b", "10"}, {"c", "20"},
                        }).collect(toMap(data -> data[0], data -> data[1])))
        );
    }

    @DisplayName("LadderGame은 Player와 Prize Name을 매핑한 게임 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource
    void ladderGameResultTest(Players testPlayers, Prizes testPrizes, Ladder testLadder, Map<String, String> expectedResults) {
        LadderGame testLadderGame = new LadderGame(testPlayers, testLadder, testPrizes);
        testLadderGame.playGame();
        Map<Player, Prize> gameResult = testLadderGame.getPlayerGameResult();

        Map<String, String> actualGameResult = gameResult.entrySet()
                .stream()
                .collect(toMap(data -> data.getKey().getName(), data -> data.getValue().getName()));

        assertThat(actualGameResult).containsExactlyEntriesOf(expectedResults);
    }
}
