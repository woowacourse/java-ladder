package domain;

import factory.LadderFactory;
import factory.PlayersFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.OutputView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void before() {
        List<String> playerNames = List.of("a", "b", "c");
        Players players = PlayersFactory.of(playerNames);
        GameResults gameResults = new GameResults(
                3,
                List.of(new GameResult("꽝"), new GameResult("꽝"), new GameResult("당첨"))
        );
        List<Point> pointsOfFirstLine = List.of(Point.EXIST, Point.NOT_EXIST);
        List<Point> pointsOfSecondLine = List.of(Point.EXIST, Point.NOT_EXIST);
        List<Point> pointsOfThirdLine = List.of(Point.NOT_EXIST, Point.NOT_EXIST);
        List<Point> pointsOfFourthLine = List.of(Point.EXIST, Point.NOT_EXIST);
        CompleteBasedStrategy completeBasedStrategy = new CompleteBasedStrategy(
                List.of(
                        pointsOfFirstLine, pointsOfSecondLine, pointsOfThirdLine, pointsOfFourthLine
                )
        );
        int ladderHeight = 4;
        Ladder ladder = LadderFactory.of(playerNames.size(), ladderHeight, completeBasedStrategy);
        ladderGame = new LadderGame(players, ladder, new GameResults(playerNames.size(), List.of(new GameResult("꽝"), new GameResult("당첨"), new GameResult("당첨"))));
    }

    @DisplayName("Ladder를 생성한다.")
    @Test
    void generateLadder() {
        Ladder ladder = ladderGame.getLadder();
        assertThat(ladder.getLines().size()).isEqualTo(4);
    }

    @DisplayName("Players를 생성한다.")
    @Test
    void generatePlayers() {
        List<String> playerNames = ladderGame.getPlayerNames();
        assertThat(playerNames).containsExactly("a", "b", "c");
    }
//
//    @DisplayName("지정한 플레이어의 게임 실행 결과를 계산한다.")
//    @Test
//    void getResultOfPlayer() {
//        String playerName = ladderGame.getPlayerNames().get(0);
//        ladderGame.getGameResultOf(playerName);
//    }

    @DisplayName("지정한 플레이어가 없는 경우 예외 처리 한다.")
    @Test
    void validatePlayerContaining() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ladderGame.getGameResultOf("d"));
    }

}
