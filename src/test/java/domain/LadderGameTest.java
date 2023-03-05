package domain;

import factory.PlayersFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

/**
 * 사다리 UI
 *  a  b  c  d  e
 *  |--|  |  |--|
 *  |  |--|  |--|
 *  |  |--|  |  |
 *  |--|  |--|  |
 * 당첨 꽝 당첨 꽝 꽝
 */

/**
 * 실행 결과
 * a - 당첨
 * b - 꽝
 * c - 꽝
 * d - 당첨
 * e - 꽝
 */
public class LadderGameTest {

    private LadderGame ladderGame;
    private Players players;

    @BeforeEach
    void before() {
        List<String> gameResultNames = List.of("당첨", "꽝", "당첨", "꽝", "꽝");
        List<String> playerNames = List.of("a", "b", "c", "d", "e");
        players = PlayersFactory.of(playerNames);
        Line pointsOfFirstLine = new Line(List.of(Point.EXIST, Point.NOT_EXIST, Point.NOT_EXIST, Point.EXIST));
        Line pointsOfSecondLine = new Line(List.of(Point.NOT_EXIST, Point.EXIST, Point.NOT_EXIST, Point.EXIST));
        Line pointsOfThirdLine = new Line(List.of(Point.NOT_EXIST, Point.EXIST, Point.NOT_EXIST, Point.NOT_EXIST));
        Line pointsOfFourthLine = new Line(List.of(Point.EXIST, Point.NOT_EXIST, Point.EXIST, Point.NOT_EXIST));

        Ladder ladder = new Ladder(List.of(pointsOfFirstLine, pointsOfSecondLine, pointsOfThirdLine, pointsOfFourthLine));
        ladderGame = new LadderGame(players, ladder, gameResultNames);
    }

    @DisplayName("지정한 플레이어의 게임 실행 결과를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"a:당첨", "b:꽝", "c:꽝", "d:당첨", "e:꽝"}, delimiter = ':')
    void getResultOfPlayer(String playerName, String expectedGameResult) {
        // when
        GameResult gameResult = ladderGame.getGameResultOf(playerName);

        // then
        assertThat(gameResult.getGameResultName())
                .isEqualTo(expectedGameResult);
    }

    /**
     * 사다리 UI
     *  a b c
     *  | | |
     * 꽝 꽝 당첨
     */
    @DisplayName("지정한 플레이어의 게임 실행 결과를 반환한다. (사다리에 Point가 없는 케이스)")
    @ParameterizedTest
    @MethodSource(value = "provideLadderGameWithNoPointsLadder")
    void getResultOfPlayerWithNoPointsLadder(
            LadderGame ladderGameWithNoPointsLadder,
            Player player,
            String expectedGameResult
    ) {
        // given
        String playerName = player.getName();

        // when
        GameResult gameResult = ladderGameWithNoPointsLadder.getGameResultOf(playerName);

        // then
        assertThat(gameResult.getGameResultName())
                .isEqualTo(expectedGameResult);
    }

    @DisplayName("PlayerName 대신 'all'을 넘겨줄 경우 Player 수만큼의 실행 결과를 반환한다.")
    @Test
    void getResultsOfAllPlayers_sizeTest() {
        // given
        GameResults gameResults = ladderGame.getGameResults();

        // when
        int expectedResultSize = 5;

        // then
        assertThat(gameResults.getGameResults())
                .hasSize(expectedResultSize);
    }

    @DisplayName("모든 Player의 실행 결과를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"a:당첨", "b:꽝", "c:꽝", "d:당첨", "e:꽝"}, delimiter = ':')
    void getResultsOfAllPlayers(String playerName, String expectedGameResult) {
        // given
        GameResults gameResults = ladderGame.getGameResults();

        // when
        GameResult gameResult = gameResults.getGameResultOf(players.get(playerName));

        // then
        assertThat(gameResult.getGameResultName())
                .isEqualTo(expectedGameResult);
    }

    @DisplayName("지정한 플레이어가 없는 경우 예외 처리 한다.")
    @Test
    void validatePlayerContaining() {
        // given
        String wrongPlayerName = "f";

        // when, then
        assertThatThrownBy(() -> ladderGame.getGameResultOf(wrongPlayerName))
                .isInstanceOf(NoSuchElementException.class);
    }

    private static Stream<Arguments> provideLadderGameWithNoPointsLadder() {
        List<String> gameResultNames = List.of("꽝", "꽝", "당첨");
        List<String> playerNames = List.of("a", "b", "c");
        Players players = PlayersFactory.of(playerNames);
        Line pointsOfFirstLine = new Line(List.of(Point.NOT_EXIST, Point.NOT_EXIST));
        Ladder ladder = new Ladder(List.of(pointsOfFirstLine));

        return Stream.of(
                Arguments.of(new LadderGame(players, ladder, gameResultNames), players.get("a"), "꽝"),
                Arguments.of(new LadderGame(players, ladder, gameResultNames), players.get("b"), "꽝"),
                Arguments.of(new LadderGame(players, ladder, gameResultNames), players.get("c"), "당첨")
        );
    }

}
