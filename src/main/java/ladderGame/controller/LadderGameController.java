package ladderGame.controller;

import java.util.ArrayList;
import java.util.List;
import ladderGame.model.Command;
import ladderGame.model.Ladder;
import ladderGame.model.RandomConnectionGenerator;
import ladderGame.model.Line;
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
        Ladder ladder = makeLadder(inputView.inputMaxLadderHeight(), players.getPlayerSize());

        resultView.printLadder(players.getPlayers(), ladder.getLines(), prizes.getPrizes());

        ladder.descendLadder(players);

        printResults(players, prizes);
    }

    private Ladder makeLadder(int height, int count) {
        List<Line> lines = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            lines.add(new Line(RandomConnectionGenerator.makeConnections(count)));
        }

        return new Ladder(lines);
    }

    private void printResults(Players players, Prizes prizes) {
        Command command = new Command(inputView.inputWantedName(), players);
        while(!command.isAll()) {
            resultView.printResult(players.findPlayer(command.toName()), prizes.getPrizes());
            command = new Command(inputView.inputWantedName(), players);
        }

        resultView.printAllResults(players.getPlayers(), prizes.getPrizes());
    }
}
