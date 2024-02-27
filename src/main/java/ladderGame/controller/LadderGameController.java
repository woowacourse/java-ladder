package ladderGame.controller;

import ladderGame.model.Ladder;
import ladderGame.model.Name;
import ladderGame.model.Players;
import ladderGame.model.Results;
import ladderGame.view.InputView;
import ladderGame.view.ResultView;

public class LadderGameController {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderGameController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void run() {
        Players players = new Players(inputView.inputPlayerNames());
        Results results = new Results(inputView.inputResults(), players.getPlayerSize());
        Ladder ladder = new Ladder(inputView.inputMaxLadderHeight(), players.getPlayerSize());

        resultView.printLadder(players.getPlayers(), ladder.getLines(), results.getResults());

        ladder.descendLadder(players);

        printResults(players, results);
    }

    private void printResults(Players players, Results results) {
        Name name = new Name(inputView.inputWantedName(), players);
        while(!name.isAll()) {
            resultView.printResult(players.findPlayer(name), results.getResults());
            name = new Name(inputView.inputWantedName(), players);
        }

        resultView.printAllResults(players.getPlayers(), results.getResults());
    }
}
