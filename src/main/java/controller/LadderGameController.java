package controller;

import domain.LadderGame;
import domain.LadderGameResult;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.player.Players;
import domain.product.Products;
import util.TrueOrFalseGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {
    public static final String TOTAL_PLAYER_SEARCH = "all";
    private final InputView inputView;
    private final OutputView outputView;
    private final TrueOrFalseGenerator trueOrFalseGenerator;


    public LadderGameController(InputView inputView, OutputView outputView, TrueOrFalseGenerator trueOrFalseGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.trueOrFalseGenerator = trueOrFalseGenerator;
    }

    public void run() {
        Players players = Players.generate(inputView.readUserNames());
        Products products = Products.generate(inputView.readProducts());
        Height height = new Height(inputView.readHeight());
        Ladder ladder = Ladder.generate(players, height, trueOrFalseGenerator);
        outputView.printResult(players, ladder, products);
        LadderGame ladderGame = new LadderGame(players, products, ladder);
        LadderGameResult ladderGameResult = ladderGame.play();
        ladderGameTotalResult(ladderGameResult);
    }

    private void ladderGameTotalResult(LadderGameResult ladderGameResult) {
        String searchByPlayerName;
        do {
            searchByPlayerName = inputView.readResult();
            outputView.printResultOfPlayerName(searchByPlayerName, ladderGameResult);
        }
        while (!searchByPlayerName.equals(TOTAL_PLAYER_SEARCH));
    }
}
