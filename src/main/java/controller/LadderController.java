package controller;

import model.ladder.Height;
import model.ladder.Ladder;
import model.ladder.Width;
import model.ladder.generator.RandomStatusGenerator;
import model.laddergame.LadderGame;
import model.players.Players;
import model.prize.Prize;
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

        outputView.printLadderResult(players.getNames(), ladder.getLines(), prizes.getPrizesName());
        checkPrize(new LadderGame(players, ladder, prizes));
    }

    private void checkPrize(LadderGame ladderGame) {
        String player = inputView.readPlayerToCheck();
        while (checkingOnePlayer(player)) {
            Prize prize = ladderGame.move(player);
            outputView.printPrizeResult(prize.getName());
            player = inputView.readPlayerToCheck();
        }
        outputView.printPrizesResult(ladderGame.moveAll());
    }

    private boolean checkingOnePlayer(final String playerToCheck) {
        return !playerToCheck.equals(InputView.CHECKING_ALL_MESSAGE);
    }
}
