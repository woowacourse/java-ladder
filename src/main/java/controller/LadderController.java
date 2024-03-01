package controller;

import model.ladder.Height;
import model.ladder.Ladder;
import model.ladder.Width;
import model.ladder.generator.RandomStatusGenerator;
import model.ladderGame.LadderGame;
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

        outputView.printLadderResult(players.getNames(), ladder.getLines(), prizes.getPrizes());
        checkPrize(new LadderGame(players, ladder, prizes));
    }

    // TODO: 이름을 기반으로 Player를 조회하는 역할이 LadderGame인지, Controller인지 고민하기
    private void checkPrize(LadderGame ladderGame) {
        String playerToCheck = "";
        while (playerToCheck != "all") {
            playerToCheck = inputView.readPlayersToCheck();
            Prize prize = ladderGame.move(playerToCheck);
            outputView.printPrize(prize.getName());
        }
    }
}
