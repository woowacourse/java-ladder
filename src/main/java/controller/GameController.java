package controller;

import domain.Game;
import domain.Height;
import domain.Lines;
import domain.Members;
import error.ErrorHandler;
import strategy.PointStrategy;
import view.InputView;
import view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ErrorHandler errorHandler;
    private final PointStrategy pointStrategy;

    public GameController(
        InputView inputView,
        OutputView outputView,
        ErrorHandler errorHandler,
        PointStrategy pointStrategy) {

        this.inputView = inputView;
        this.outputView = outputView;
        this.errorHandler = errorHandler;
        this.pointStrategy = pointStrategy;
    }

    public void start() {
        String rawNames = errorHandler.readUntilNoError(inputView::readNames);
        String rawHeight = errorHandler.readUntilNoError(inputView::readHeight);

        Members members = Members.from(rawNames);
        Lines lines = Lines.of(
            members.getCount(), Height.from(rawHeight), pointStrategy);

        Game game = Game.of(members, lines);
        outputView.printResult(game);
    }
}
