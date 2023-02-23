package laddergame.controller;

import java.util.List;
import java.util.Objects;
import laddergame.domain.LadderGame;
import laddergame.domain.ladder.GameResult;
import laddergame.domain.ladder.Ladder;
import laddergame.view.InputView;
import laddergame.view.OutputView;
import laddergame.view.constant.FindCommand;

public class LadderGameController {

    private LadderGame game;
    private GameStatus gameStatus = GameStatus.START;

    public void run() {
        Ladder ladder = play();

        showLadderResult(ladder);
        GameResult gameResult = game.computeResult();

        while (gameStatus == GameStatus.PLAYED) {
            String keyword = InputView.askFindResultKeyword();
            showGameResult(gameResult, keyword);
        }
    }

    private Ladder play() {
        List<String> players = InputView.askPlayerNames();
        game = new LadderGame(players);
        List<String> results = InputView.askLadderResults();
        int height = InputView.askLadderHeight();
        game.generateLadder(height, results);
        return game.ladder();
    }

    private void showLadderResult(Ladder ladder) {
        gameStatus = GameStatus.PLAYED;
        OutputView.showLadderResult(game.playerNames(), ladder.toLadderLines(), ladder.toResults());
    }

    private void showGameResult(GameResult gameResult, String keyword) {
        validateGameStatus(gameStatus);
        if (Objects.equals(FindCommand.QUIT, keyword)) {
            gameStatus = GameStatus.QUIT;
            return;
        }
        if (Objects.equals(FindCommand.FIND_ALL, keyword)) {
            OutputView.showAllResultsByPlayer(gameResult.result());
            return;
        }
        OutputView.showResultByPlayer(gameResult.findByPlayerName(keyword));
    }

    private void validateGameStatus(GameStatus gameStatus) {
        if (gameStatus == GameStatus.START) {
            throw new IllegalStateException("아직 사다리가 생성되지 않은 게임입니다.");
        }
    }
}
