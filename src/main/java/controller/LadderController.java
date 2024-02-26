package controller;

import model.Height;
import model.Ladder;
import model.Player;
import model.Players;
import model.Result;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Players players = new Players(inputView.readPlayersName());
        Result result = Result.of(inputView.readResult(), players.size());

        Height height = new Height(inputView.readHeight());

        Ladder ladder = Ladder.of(height, players.size());


        outputView.printLadderResult(players.getNames(), ladder.getFormattedLines(), result.getPrizes());
        Player player = new Player(inputView.readPlayerWantCheckResult());
        outputView.printPlayerResult(ladder.findResult(players, player, result.getPrizes()).toString());
    }
}
