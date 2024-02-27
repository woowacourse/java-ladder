package domain;

import domain.ladder.FixedDirectionGenerator;
import domain.ladder.Ladder;
import domain.ladder.attirbute.Direction;
import domain.ladder.attirbute.Height;
import domain.player.Name;
import domain.player.Names;
import domain.player.Players;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.RandomDirectionGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


class GameBoardTest {
    @Test
    @DisplayName("Player 와 사다리를 통해 게임 보드를 만든다.")
    void createGameBoard() {
        Players players = 플레이어_생성(new Names(List.of("도비", "조이썬", "포비", "크롱")));

        Height height = new Height("5");
        Ladder ladder = new Ladder(height, players.getPlayerCount(), new RandomDirectionGenerator());
        Prizes prizes = new Prizes(List.of("꽝", "꽝", "꽝", "꽝"), 4);
        GameBoard gameBoard = new GameBoard(players, ladder, prizes);

        assertInstanceOf(GameBoard.class, gameBoard);

    }

    private Players 플레이어_생성(Names names) {
        return new Players(names);
    }

    /**
     * 테스트용 사다리는 가로방향의 다리가 없이 아래 방향으로만 이루어지게 생성된다.
     * 실행 결과는 입력된 모든 플레이어와 상품을 포함하고 있어야한다.
     * 본 테스트에서 각 플레이어는 플레이어의 입력 순서와 일치한 입력 순서의 상품을 배정 받아야된다.
     */
    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class GenerateResultTestClass {

        private final Prizes prizes = new Prizes(List.of("1", "2", "3", "4"), 4);
        private Players players;
        private Map<Name, Prize> results;
        private GameBoard gameBoard;

        @BeforeEach
        void setUp() {
            // Given
            players = 플레이어_생성(new Names(List.of("도비", "조이썬", "포비", "오리")));
            Height height = new Height("4");
            List<Direction> fixedDirectionList = IntStream.rangeClosed(0, 15)
                                                          .mapToObj((value) -> Direction.DOWN)
                                                          .toList();
            Ladder ladder = new Ladder(height, players.getPlayerCount(), new FixedDirectionGenerator(fixedDirectionList));
            gameBoard = new GameBoard(players, ladder, prizes);

            // When
            results = gameBoard.getAllPlayerResult();
        }

        private List<Prize> providePrize() {
            return prizes.getValue();
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
            assertTrue(results.containsKey(new Name(playerName)));
        }

        @ParameterizedTest
        @MethodSource("providePrize")
        @DisplayName("게임 결과에는 모든 실행 결과가 포함된다.")
        void testContainsAllPrizes(Prize prize) {
            // Then
            assertTrue(results.containsValue(prize));
        }

        @Test
        @DisplayName("게임 결과에는 입력된 플레이어의 순서가 유지된 상태로 결과에 저장된다.")
        void testPlayerOrder() {
            List<Name> playerNames = players.getPlayerNames();
            List<Name> resultPlayerNames = new ArrayList<>(results.keySet());

            // Then
            assertEquals(playerNames, resultPlayerNames);
        }

        @Test
        @DisplayName("사다리 게임의 실행 결과는 올바르게 Name : Prize 가 매칭되어 생성된다.")
        void testResultIsMatchedCorrectly() {
            Prize expectedPrize1 = prizes.getValue()
                                         .get(0);
            Prize expectedPrize2 = prizes.getValue()
                                         .get(1);
            Prize expectedPrize3 = prizes.getValue()
                                         .get(2);
            Prize expectedPrize4 = prizes.getValue()
                                         .get(3);

            // Then
            assertAll(() -> {
                assertEquals(expectedPrize1, results.get(new Name("도비")));
                assertEquals(expectedPrize2, results.get(new Name("조이썬")));
                assertEquals(expectedPrize3, results.get(new Name("포비")));
                assertEquals(expectedPrize4, results.get(new Name("오리")));
            });
        }

        @Test
        @DisplayName("특정 플레이어의 Prize를 검색하여 반환한다.")
        void searchSpecificPlayersPrize() {
            // When
            Prize resultPrize1 = gameBoard.getSpecificPlayerResult(new Name("도비"));
            Prize resultPrize2 = gameBoard.getSpecificPlayerResult(new Name("조이썬"));
            Prize resultPrize3 = gameBoard.getSpecificPlayerResult(new Name("포비"));
            Prize resultPrize4 = gameBoard.getSpecificPlayerResult(new Name("오리"));

            Prize expectedPrize1 = prizes.getValue()
                                         .get(0);
            Prize expectedPrize2 = prizes.getValue()
                                         .get(1);
            Prize expectedPrize3 = prizes.getValue()
                                         .get(2);
            Prize expectedPrize4 = prizes.getValue()
                                         .get(3);

            // Then
            assertAll(() -> {
                assertEquals(expectedPrize1, resultPrize1);
                assertEquals(expectedPrize2, resultPrize2);
                assertEquals(expectedPrize3, resultPrize3);
                assertEquals(expectedPrize4, resultPrize4);
            });

        }
    }

}
