package ladderGame.controller;

import ladderGame.model.Ladder;
import ladderGame.model.Name;
import ladderGame.model.Players;
import ladderGame.model.Prizes;
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
        Prizes prizes = new Prizes(inputView.inputPrizes(), players.getPlayerSize());
        Ladder ladder = new Ladder(inputView.inputMaxLadderHeight(), players.getPlayerSize());

        resultView.printLadder(players.getPlayers(), ladder.getLines(), prizes.getPrizes());

        ladder.descendLadder(players);

        printResults(players, prizes);
    }

    private void printResults(Players players, Prizes prizes) {
        Name name = new Name(inputView.inputWantedName(), players);
        while(!name.isAll()) {
            resultView.printResult(players.findPlayer(name), prizes.getPrizes());
            name = new Name(inputView.inputWantedName(), players);
        }

        resultView.printAllResults(players.getPlayers(), prizes.getPrizes());
    }
}
