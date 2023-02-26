package laddergame.controller;

import java.util.List;
import java.util.Objects;
import laddergame.domain.LadderGame;
import laddergame.domain.ladder.GameResult;
import laddergame.domain.ladder.Ladder;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {

    private LadderGame game;
    private GameStatus gameStatus = GameStatus.START;

    public void run() {
        Ladder ladder = play();

        showLadderResult(ladder);
        GameResult gameResult = game.computeResult();

        while (gameStatus == GameStatus.PLAYED) {
            String keyword = InputView.askSearchKeyword();
            searchFromGameResult(gameResult, keyword);
        }
    }

    private Ladder play() {
        List<String> players = InputView.askPlayerNames();
        game = new LadderGame(players);
        List<String> items = InputView.askDestinationItems();
        int height = InputView.askLadderHeight();
        game.generateLadder(height, items);
        return game.ladder();
    }

    private void showLadderResult(Ladder ladder) {
        gameStatus = GameStatus.PLAYED;
        OutputView.showLadderResult(game.playerNames(), ladder.toLadderLines(), ladder.toDestinationItems());
    }

    private void searchFromGameResult(GameResult gameResult, String keyword) {
        validateGameStatus(gameStatus);
        if (Objects.equals(SearchKeyword.QUIT, keyword)) {
            gameStatus = GameStatus.QUIT;
            return;
        }
        if (Objects.equals(SearchKeyword.FIND_ALL, keyword)) {
            OutputView.showAllItemsByPlayer(gameResult.result());
            return;
        }
        OutputView.showItemByPlayer(gameResult.findByPlayerName(keyword));
    }

    private void validateGameStatus(GameStatus gameStatus) {
        if (gameStatus == GameStatus.START) {
            throw new IllegalStateException("아직 사다리가 생성되지 않은 게임입니다.");
        }
    }
}
