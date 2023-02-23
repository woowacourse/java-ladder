package laddergame.controller;

import java.util.List;
import java.util.Objects;
import laddergame.domain.LadderGame;
import laddergame.domain.ladder.line.Line;
import laddergame.view.constant.FindCommand;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {

    private LadderGame game;

    public void run() {
        GameStatus gameStatus = GameStatus.RUN;
        play();
        while (gameStatus == GameStatus.RUN) {
            gameStatus = findResultByPlayer();
        }
    }

    public void play() {
        List<String> players = InputView.askPlayerNames();

        game = new LadderGame(players);
        List<String> results = InputView.askLadderResults();
        int height = InputView.askLadderHeight();
        List<Line> ladderLines = game.generateLadder(height, results);

        OutputView.showLadderResult(game.getPlayerNames(), ladderLines, results);
    }

    public GameStatus findResultByPlayer() {
        OutputView.showGameResultMessage();
        String keyword = InputView.askFindResultKeyword();

        if (Objects.equals(FindCommand.QUIT, keyword)) {
            return GameStatus.QUIT;
        }
        if (Objects.equals(FindCommand.FIND_ALL, keyword)) {
            OutputView.showAllResultsByPlayer(game.findAllResultsByPlayer());
            return GameStatus.RUN;
        }
        OutputView.showResultByPlayer(game.findResultByPlayerName(keyword));
        return GameStatus.RUN;
    }
}
