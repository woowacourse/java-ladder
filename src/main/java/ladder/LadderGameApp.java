package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameApp {
    public static void main(String[] args) {
        Players players = new Players(InputView.getNames());
        Results results = InputView.getResult(players.getPlayerNum());
        Ladder ladder = InputView.createLadder(players.getPlayerNum());

        OutputView.printLadderGameBoard(players, results, ladder);

        LadderGame game = new LadderGame(ladder);
        game.movePlayers(players);

        LadderGameResult gameResult = new LadderGameResult(players, results);

        String inputName;

        do {
            inputName = InputView.inputNameForResult();
            OutputView.printGameResult(inputName, gameResult);
        } while (!"all".equals(inputName));

        OutputView.printAllGameResults(gameResult);
        OutputView.printEnd();
    }
}
