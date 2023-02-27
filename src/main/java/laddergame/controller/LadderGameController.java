package laddergame.controller;

import java.util.List;
import laddergame.domain.LadderGame;
import laddergame.domain.ladder.GameResult;
import laddergame.domain.ladder.Ladder;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {

    private LadderGame game;
    private GameStatus gameStatus = GameStatus.START;

    public void run() {
        final Ladder ladder = play();

        showLadderResult(ladder);
        final GameResult gameResult = game.computeResult();

        while (gameStatus == GameStatus.PLAYED) {
            final String keyword = InputView.askSearchKeyword();
            searchFromGameResult(gameResult, keyword);
        }
    }

    private Ladder play() {
        final List<String> players = InputView.askPlayerNames();
        game = new LadderGame(players);
        final List<String> items = InputView.askDestinationItems();
        final int height = InputView.askLadderHeight();
        game.generateLadder(height, items);
        return game.ladder();
    }

    private void showLadderResult(Ladder ladder) {
        gameStatus = GameStatus.PLAYED;
        OutputView.showLadderResult(game.playerNames(), ladder.toLadderLines(), ladder.toDestinationItems());
    }

    private void searchFromGameResult(final GameResult gameResult, final String keyword) {
        validateGameStatus(gameStatus);
        final SearchType searchType = SearchType.match(keyword);
        if (searchType == SearchType.QUIT) {
            gameStatus = GameStatus.QUIT;
            return;
        }
        if (searchType == SearchType.FIND_ALL) {
            OutputView.showAllItemsByPlayer(gameResult.result());
            return;
        }
        OutputView.showItemByPlayer(gameResult.findByPlayerName(keyword));
    }

    private void validateGameStatus(final GameStatus gameStatus) {
        if (gameStatus == GameStatus.START) {
            throw new IllegalStateException("아직 사다리가 생성되지 않은 게임입니다.");
        }
    }
}
