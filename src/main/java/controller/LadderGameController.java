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
    private static final String ALL_CONDITION = "all";
    private boolean quitCondition = true;
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
        LadderGameResult ladderGameResult = ladderGame.gameResult();
        ladderGameTotalResult(ladderGameResult);
    }

    private void ladderGameTotalResult(LadderGameResult ladderGameResult) {
        while (quitCondition) {
            String searchByPlayerName = inputView.readResult();
            outputView.printResultOfPlayerName(searchByPlayerName, ladderGameResult);
            isInputAll(searchByPlayerName);
        }
    }

    private void isInputAll(final String input) {
        if (input.equals(ALL_CONDITION)) {
            quitCondition = false;
        }
    }
}
