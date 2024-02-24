package controller;

import domain.Game;
import domain.Height;
import domain.Lines;
import domain.Members;
import error.ErrorHandler;
import strategy.RandomPointStrategy;
import view.InputView;
import view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ErrorHandler errorHandler;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.errorHandler = new ErrorHandler();
    }

    public void run() {
        String rawNames = errorHandler.readUntilNoError(inputView::readNames);
        String rawHeight = errorHandler.readUntilNoError(inputView::readHeight);

        Members members = Members.from(rawNames);
        Lines lines = Lines.of(
            members.getCount(), Height.from(rawHeight), new RandomPointStrategy());

        Game game = Game.of(members, lines);
        outputView.printResult(game);
    }
}
