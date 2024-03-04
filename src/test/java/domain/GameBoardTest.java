package domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import domain.ladder.FixedDirectionGenerator;
import domain.ladder.Ladder;
import domain.ladder.attirbute.Direction;
import domain.ladder.attirbute.Height;
import domain.player.PlayerName;
import domain.player.PlayerNames;
import domain.player.Players;
import domain.prize.PrizeName;
import domain.prize.PrizeNames;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.RandomDirectionGenerator;


class GameBoardTest {
    @Test
    @DisplayName("Player 와 사다리를 통해 게임 보드를 만든다.")
    void createGameBoard() {
        Players players = 플레이어_생성(new PlayerNames(List.of("도비", "조이썬", "포비", "크롱")));

        Height height = new Height("5");
        Ladder ladder = new Ladder(height, players.getPlayerCount(), new RandomDirectionGenerator());
        PrizeNames prizeNames = new PrizeNames(List.of("꽝", "꽝", "꽝", "꽝"), 4);
        GameBoard gameBoard = new GameBoard(players, ladder, prizeNames);

        assertInstanceOf(GameBoard.class, gameBoard);
    }

    private Players 플레이어_생성(PlayerNames playerNames) {
        return new Players(playerNames);
    }

    /**
     * 테스트용 사다리는 가로방향의 다리가 없이 아래 방향으로만 이루어지게 생성된다. 실행 결과는 입력된 모든 플레이어와 상품을 포함하고 있어야한다. 본 테스트에서 각 플레이어는 플레이어의 입력 순서와 일치한
     * 입력 순서의 상품을 배정 받아야된다.
     */
    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class GenerateResultTestClass {

        private final PrizeNames prizeNames = new PrizeNames(List.of("1", "2", "3", "4"), 4);
        private Players players;
        private Map<PlayerName, PrizeName> results;
        private GameBoard gameBoard;

        @BeforeEach
        void setUp() {
            // Given
            players = 플레이어_생성(new PlayerNames(List.of("도비", "조이썬", "포비", "오리")));
            Height height = new Height("4");
            List<Direction> fixedDirectionList = IntStream.rangeClosed(0, 15)
                    .mapToObj((value) -> Direction.DOWN)
                    .toList();
            Ladder ladder = new Ladder(height, players.getPlayerCount(),
                    new FixedDirectionGenerator(fixedDirectionList));
            gameBoard = new GameBoard(players, ladder, prizeNames);

            // When
            results = gameBoard.searchAllPlayerResult();
        }

        private List<PrizeName> providePrize() {
            return prizeNames.getValue();
        }

        @Test
        @DisplayName("사다리가 생성될 때 입력된 모든 Player의 이름과 실행 결과를 가지는 게임 결과를 함께 생성한다.")
        void testGenerateGameResultWhenConstructed() {
            // Then
            assertAll(() -> {
                assertEquals(4, results.keySet()
                        .size());
                assertEquals(4, results.values()
                        .size());
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"도비", "조이썬", "포비", "오리"})
        @DisplayName("게임 결과에는 입력된 모든 플레이어가 포함된다.")
        void testContainsAllPlayers(String playerName) {
            // Then
            assertTrue(results.containsKey(new PlayerName(playerName)));
        }

        @ParameterizedTest
        @MethodSource("providePrize")
        @DisplayName("게임 결과에는 모든 실행 결과가 포함된다.")
        void testContainsAllPrizes(PrizeName prizeName) {
            // Then
            assertTrue(results.containsValue(prizeName));
        }

        @Test
        @DisplayName("게임 결과에는 입력된 플레이어의 순서가 유지된 상태로 결과에 저장된다.")
        void testPlayerOrder() {
            List<PlayerName> playerPlayerNames = players.getPlayerNames();
            List<PlayerName> resultPlayerPlayerNames = new ArrayList<>(results.keySet());

            // Then
            assertEquals(playerPlayerNames, resultPlayerPlayerNames);
        }

        @Test
        @DisplayName("사다리 게임의 실행 결과는 올바르게 PlayerName : PrizeName 가 매칭되어 생성된다.")
        void testResultIsMatchedCorrectly() {
            PrizeName expectedPrize1Name = prizeNames.getValue()
                    .get(0);
            PrizeName expectedPrize2Name = prizeNames.getValue()
                    .get(1);
            PrizeName expectedPrize3Name = prizeNames.getValue()
                    .get(2);
            PrizeName expectedPrize4Name = prizeNames.getValue()
                    .get(3);

            // Then
            assertAll(() -> {
                assertEquals(expectedPrize1Name, results.get(new PlayerName("도비")));
                assertEquals(expectedPrize2Name, results.get(new PlayerName("조이썬")));
                assertEquals(expectedPrize3Name, results.get(new PlayerName("포비")));
                assertEquals(expectedPrize4Name, results.get(new PlayerName("오리")));
            });
        }

        @Test
        @DisplayName("특정 플레이어의 Prize를 검색하여 반환한다.")
        void searchSpecificPlayersPrize() {
            // When
            String resultPrize1 = gameBoard.searchOnePlayerResult(new PlayerName("도비"));
            String resultPrize2 = gameBoard.searchOnePlayerResult(new PlayerName("조이썬"));
            String resultPrize3 = gameBoard.searchOnePlayerResult(new PlayerName("포비"));
            String resultPrize4 = gameBoard.searchOnePlayerResult(new PlayerName("오리"));

            // Then
            assertAll(() -> {
                assertEquals("1", resultPrize1);
                assertEquals("2", resultPrize2);
                assertEquals("3", resultPrize3);
                assertEquals("4", resultPrize4);
            });
        }

        @Test
        @DisplayName("존재하지 않은 플레이어의 이름을 검색하면 예외와 메세지를 던진다.")
        void whenSearchNotExistingPlayerThenReturnMessage() {
            PlayerName targetPlayerName = new PlayerName("없는사람");
            assertAll(() -> {
                Exception exception = assertThrows(IllegalArgumentException.class,
                        () -> gameBoard.searchOnePlayerResult(targetPlayerName));
                String expectedMessage = "존재하지 않는 플레이어입니다.";
                String actualMessage = exception.getMessage();
                assertEquals(expectedMessage, actualMessage);
            });
        }
    }

}
