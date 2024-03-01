package controller;

import model.ladder.Height;
import model.ladder.Ladder;
import model.ladder.Width;
import model.ladder.generator.RandomStatusGenerator;
import model.players.Player;
import model.players.Players;
import model.prize.Prizes;
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
        Prizes prizes = Prizes.of(inputView.readPrizes(), players.size());
        Height height = new Height(inputView.readHeight());

        Ladder ladder = Ladder.of(height, Width.from(players.size()), new RandomStatusGenerator());

        outputView.printLadderResult(players.getNames(), ladder.getLines(), prizes.getPrizes());

    }

    private void checkPrize(Players players) {
        Player player = players.findByName(inputView.readPlayerNameToCheck());
    }
}
