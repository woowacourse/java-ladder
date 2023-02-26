package domain;

import factory.LadderFactory;
import factory.PlayersFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * 사다리 UI
 *  a  b  c  d  e
 *  |--|  |  |--|
 *  |  |--|  |--|
 *  |  |--|  |  |
 *  |--|  |--|  |
 * 당첨 꽝 당첨 꽝 꽝
 */
public class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void before() {
        List<String> playerNames = List.of("a", "b", "c", "d", "e");
        Players players = PlayersFactory.of(playerNames);
        GameResults gameResults = new GameResults(
                5,
                List.of(new GameResult("당첨"), new GameResult("꽝"), new GameResult("당첨"), new GameResult("꽝"), new GameResult("꽝"))
        );
        List<Point> pointsOfFirstLine = List.of(Point.EXIST, Point.NOT_EXIST, Point.NOT_EXIST, Point.EXIST);
        List<Point> pointsOfSecondLine = List.of(Point.NOT_EXIST, Point.EXIST, Point.NOT_EXIST, Point.EXIST);
        List<Point> pointsOfThirdLine = List.of(Point.NOT_EXIST, Point.EXIST, Point.NOT_EXIST, Point.NOT_EXIST);
        List<Point> pointsOfFourthLine = List.of(Point.EXIST, Point.NOT_EXIST, Point.EXIST, Point.NOT_EXIST);
        CompleteBasedStrategy completeBasedStrategy = new CompleteBasedStrategy(
                List.of(
                        pointsOfFirstLine, pointsOfSecondLine, pointsOfThirdLine, pointsOfFourthLine
                )
        );
        int ladderHeight = 4;
        Ladder ladder = LadderFactory.of(playerNames.size(), ladderHeight, completeBasedStrategy);
        ladderGame = new LadderGame(players, ladder, gameResults);
    }

    @DisplayName("Ladder를 생성한다.")
    @Test
    void generateLadder() {
        Ladder ladder = ladderGame.getLadder();
        assertThat(ladder.getLines().size()).isEqualTo(4);
    }

    @DisplayName("PointGenerateStrategy를 사용해 Ladder를 생성한다.")
    @Test
    void generateLadderByPointGenerateStrategy() {
        Ladder ladder = ladderGame.getLadder();
        ladder.getLines().stream().map(line -> line.getPoints().stream().map(Point::isExist).collect(Collectors.toList()))
                .forEach(System.out::println);
        assertThat(ladder.getLines().size()).isEqualTo(4);
    }

    @DisplayName("Players를 생성한다.")
    @Test
    void generatePlayers() {
        List<String> playerNames = ladderGame.getPlayerNames();
        assertThat(playerNames).containsExactly("a", "b", "c", "d", "e");
    }

    @DisplayName("지정한 플레이어의 게임 실행 결과를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"a:당첨", "b:꽝", "c:꽝", "d:당첨", "e:꽝"}, delimiter = ':')
    void getResultOfPlayer(String playerName, String gameResult) {
        assertThat(ladderGame.getGameResultOf(playerName).getResult())
                .isEqualTo(gameResult);
    }

    @DisplayName("사다리에 Point가 없는 경우 지정한 플레이어의 게임 실행 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource(value = "provideLadderGame")
    void getResultOfPlayerWithNoPointsLadder(LadderGame ladderGame2, List<String> expected) {
        assertThat(ladderGame2.getGameResultOf(expected.get(0)).getResult())
                .isEqualTo(expected.get(1));
    }

    @DisplayName("모든 Player의 실행 결과를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"a:당첨", "b:꽝", "c:꽝", "d:당첨", "e:꽝"}, delimiter = ':')
    void getResultsOfAllPlayers(String playerName, String gameResult) {
        LinkedHashMap<String, GameResult> results = ladderGame.getGameResultsOfAllPlayers();
        assertThat(results.get(playerName).getResult())
                .isEqualTo(gameResult);
    }

    @DisplayName("지정한 플레이어가 없는 경우 예외 처리 한다.")
    @Test
    void validatePlayerContaining() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ladderGame.getGameResultOf("f"));
    }

    private static Stream<Arguments> provideLadderGame() {
        List<String> playerNames = List.of("a", "b", "c");
        Players players = PlayersFactory.of(playerNames);
        GameResults gameResults = new GameResults(
                3,
                List.of(new GameResult("꽝"), new GameResult("꽝"), new GameResult("당첨"))
        );
        List<Point> pointsOfFirstLine = List.of(Point.NOT_EXIST, Point.NOT_EXIST);
        List<Point> pointsOfSecondLine = List.of(Point.NOT_EXIST, Point.NOT_EXIST);
        List<Point> pointsOfThirdLine = List.of(Point.NOT_EXIST, Point.NOT_EXIST);
        List<Point> pointsOfFourthLine = List.of(Point.NOT_EXIST, Point.NOT_EXIST);
        CompleteBasedStrategy completeBasedStrategy = new CompleteBasedStrategy(
                List.of(
                        pointsOfFirstLine, pointsOfSecondLine, pointsOfThirdLine, pointsOfFourthLine
                )
        );
        int ladderHeight = 3;
        Ladder ladder = LadderFactory.of(playerNames.size(), ladderHeight, completeBasedStrategy);

        return Stream.of(
                Arguments.of(new LadderGame(players, ladder, gameResults), List.of("a", "꽝")),
                Arguments.of(new LadderGame(players, ladder, gameResults), List.of("b", "꽝")),
                Arguments.of(new LadderGame(players, ladder, gameResults), List.of("c", "당첨"))
        );
    }

}
