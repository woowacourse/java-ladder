package ladder.controller;

import static ladder.view.FindCommand.FIND_ALL;

import java.util.List;
import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {

    private LadderGame game;

    public void run() {
        play();
        String playerName = InputView.askPlayerNameForResult();
        // TODO 종료할 때까지 반복하기
        findResultByPlayer(playerName);
    }

    public void play() {
        List<String> players = InputView.askPlayerNames();

        game = new LadderGame(players);
        List<String> results = InputView.askLadderResults();
        int height = InputView.askLadderHeight();
        List<Line> ladderLines = game.makeLadder(height, results);

        OutputView.showLadderResult(game.getPlayerNames(), ladderLines, results);
    }

    public void findResultByPlayer(String playerName) {
        OutputView.showGameResultMessage();
        
        if (FIND_ALL.equals(playerName)) {
            OutputView.showAllResultsByPlayer(game.findAllResultsByPlayer());
            return;
        }
        OutputView.showResultByPlayer(game.findResultByPlayerName(playerName));
    }
}
